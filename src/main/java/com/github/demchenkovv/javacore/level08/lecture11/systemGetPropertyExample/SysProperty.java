package com.github.demchenkovv.javacore.level08.lecture11.systemGetPropertyExample;

// package javax.org.lang;

/**
 * @Date: 2013-6-18
 * @Author: jilongliang
 * @Descripting: System.getProperty подробное объяснение
 */
@SuppressWarnings("all")
public class SysProperty {
    public static void main(String[] args) {
        System.out.println(userDir());
    }
	 /** Получите имя операционной системы*/
    private static String osName() {
        return System.getProperty("os.name");
    }
	 /** Получить версию операционной системы*/
    private static String osVersion() {
        return System.getProperty("os.version");
    }
	 /** Получить поставщика среды Java*/
    private static String vendor() {
        return System.getProperty("java.vendor");
    }
	 /** url*/
    private static String vendorUrl() {
        return System.getProperty("java.vendor.url");
    }
	 /** Справочник по установке Java*/
    private static String home() {
        return System.getProperty("java.home");
    }
	 /** Получите версию класса*/
    private static String classVersion() {
        return System.getProperty("java.class.version");
    }
    /**
     * Путь класса Java
     * @return
     */
    private static String classPath() {
        return System.getProperty("java.class.path");
    }
    /**
     * Архитектура операционной системы
     * @return
     */
    private static String osArch() {

        return System.getProperty("os.arch");
    }
    /**
     * Получите имя учетной записи пользователя
     * @return
     */
    private static String userName() {
        return System.getProperty("user.name");
    }
    /**
     * Получите основной список просмотров пользователя
     * @return
     */
    private static String userHome() {
        return System.getProperty("user.home");
    }
    /**
     * Текущий рабочий каталог пользователя
     * @return
     */
    private static String userDir() {
        return System.getProperty("user.dir");
    }
    /**
     * Версия спецификации виртуальной машины Java
     * @return
     */
    private static String vmSpecificationVersion() {
        return System.getProperty("java.vm.specification.version");
    }
    /**
     * Стандартизированный поставщик виртуальной машины Java
     * @return
     */
    private static String vmSpecificationVendor() {
        return System.getProperty("java.vm.specification.vendor");
    }
    /**
     * Имя спецификации виртуальной машины Java
     * @return
     */
    private static String vmSpecificationName() {
        return System.getProperty("java.vm.specification.name");
    }
    /**
     * Версия реализации виртуальной машины Java
     * @return
     */
    private static String vmVersion() {
        return System.getProperty("java.vm.version");
    }
    /**
     * Виртуальная машина Java, чтобы реализовать поставщиков
     * @return
     */
    private static String vmVendor() {
        return System.getProperty("java.vm.vendor");
    }
    /**
     * Имя реализации виртуальной машины Java
     * @return
     */
    private static String vmName() {
        return System.getProperty("java.vm.name");
    }
    /**
     * Один или несколько расширенного пути каталога
     * @return
     */
    private static String extDirs() {
        return System.getProperty("java.ext.dirs");
    }
    /**
     *Список поиска пути при загрузке библиотеки
     * @return
     */
    private static String library() {
        return System.getProperty("java.library.path");
    }
    /**
     * Сепаратор файла ("/" в системе UNIX)
     * @return
     */
    private static String fileSeparator() {
        return System.getProperty("file.separator");
    }
    /**
     * Разделители пути (в системе UNIX ":")
     * @return
     */
    private static String pathSeparator() {
        return System.getProperty("path.separator");
    }
    /**
     * Символы разделения линии ("/n" в системе UNIX)
     * @return
     */
    private static String lineSeparator() {
        return System.getProperty("line.separator");
    }
    /**
     * Имя компилятора JIT, который будет использоваться
     * @return
     */
    private static String compiler() {
        return System.getProperty("java.compiler");
    }

    /**
     * C: \ users \ admini ~ 1 \ appdata \ local \ temp \ Получить текущий временный каталог
     *
     * @return
     */
    public static String getSystempPath() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     *
     *
     * @return
     */
    public static String getSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     * Например: File:/d: /workspaces/myeclipse%208.6/myapp/webroot/web-inf/classes/
     * После обработки: D: \ Workspaces \ myeclipse%208.6 \ napp \ webroot \ Получить путь текущего проекта
     *
     * @return
     */
    public static String getSysPath() {
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        System.out.println(path);
        String temp = path.replaceFirst("file:/", "").replaceFirst("WEB-INF/classes/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

    /**
     * Необработанный d: /workspaces/myeclipse%208.6/myapp/webroot/web-inf/classes/ был обработан
     * D:\Workspaces\MyEclipse%208.6\myapp\WebRoot\WEB-INF\classes\
     *
     * @return
     */
    public static String getClassPath() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
        String temp = path.replaceFirst("file:/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

}
