package test.bgl.com.annotationprocessor;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * @desc:
 *
 * @author: baoguolin
 * @date: 2018/4/9
 */
@SupportedAnnotationTypes({"test.bgl.com.annotationprocessor.FindView"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
@AutoService(Processor.class)
public class CustomProcessor extends AbstractProcessor {

    private Map<String, ProxyClass> mProxyClassMap = new HashMap<>();
    Elements mElements;
    Filer mFiler;
    Messager mMessager;
    Types mTypes;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mElements = processingEnv.getElementUtils();
        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();
        mTypes = processingEnv.getTypeUtils();
    }

    @Override
    public Set<String> getSupportedOptions() {
        return super.getSupportedOptions();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return super.getSupportedAnnotationTypes();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations,
                           RoundEnvironment roundEnv) {
        // annotations这个集合是我们在getSupportedAnnotationTypes()返回的该处理器支持的注解类型
        for (TypeElement typeElement: annotations) {
            System.out.println("注解类型: " + typeElement.getSimpleName() + "\n");

            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)) {
                System.out.println("被注解的属性: " + element.getSimpleName());
                if (!isValid(element)) {
                    return true;
                }
                parseViewById(element);
            }

            for (ProxyClass proxyClass_ : mProxyClassMap.values()) {
                try {
                    proxyClass_.generateProxy().writeTo(mFiler);
                } catch (IOException e) {

                }
            }
            mProxyClassMap.clear();
        }
        return true;
    }

    /**
     * 验证被注解的属性是否支持
     * @param element
     * @return
     */
    private boolean isValid(Element element) {
        boolean isValid = true;

        //获取变量的所在的父元素，肯能是类、接口、枚举
        TypeElement enclosingElement = (TypeElement) element.getEnclosingElement();
        //父元素的全限定名
        String qualifiedName = enclosingElement.getQualifiedName().toString();

        Set<Modifier> modifiers = element.getModifiers();
        if (modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.STATIC)) {
            isValid = false;
//            所在的类不能是private或static修饰
        }

        // 父元素必须是类，而不能是接口或枚举
        if (enclosingElement.getKind() != ElementKind.CLASS) {
            isValid = false;
        }

        //不能在Android框架层注解
        if (qualifiedName.startsWith("android.")) {
            return false;
        }

        //不能在java框架层注解
        if (qualifiedName.startsWith("java.")) {
            return false;
        }

        return isValid;
    }

    /**
     * 处理ViewById注解
     *
     * @param element
     */
    private void parseViewById(Element element) {
        ProxyClass proxyClass = getProxyClass(element);
        //把被注解的view对象封装成一个model，放入代理类的集合中
        FieldViewBinding bindView = new FieldViewBinding(element);
        proxyClass.add(bindView);
    }

    /**
     * 生成或获取注解元素所对应的ProxyClass类
     */
    private ProxyClass getProxyClass(Element element) {
        //被注解的变量所在的类
        TypeElement classElement = (TypeElement) element.getEnclosingElement();
        String qualifiedName = classElement.getQualifiedName().toString();
        ProxyClass proxyClass = mProxyClassMap.get(qualifiedName);
        if (proxyClass == null) {
            //生成每个宿主类所对应的代理类，后面用于生产java文件
            proxyClass = new ProxyClass(classElement, mElements);
            mProxyClassMap.put(qualifiedName, proxyClass);
        }
        return proxyClass;
    }
}
