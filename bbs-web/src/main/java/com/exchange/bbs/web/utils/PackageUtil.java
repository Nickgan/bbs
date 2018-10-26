package com.exchange.bbs.web.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * 包工具类
 *
 * @author gan
 * @since 2016年5月25日下午6:54:10
 */
public class PackageUtil {

    /**
     * 扫描获取一个包及其子包下面的所有类的字节码反射类
     *
     * @param packageName 包名:传入格式:com.ganbo.base.cn
     * @return
     * @throws Exception
     */
    public static Set<Class<?>> scanClassesByPackage(String packageName) {
        Set<Class<?>> sets = new HashSet<Class<?>>();
        if (StringUtils.isBlank(packageName)) {
            return sets;
        }
        packageName = packageName.replaceAll("\\.", "/");
        if (PackageUtil.class.getClassLoader().getResource(packageName) == null) {
            return sets;
        }
        String path = PackageUtil.class.getClassLoader().getResource(packageName).getPath();
        File dir = new File(path);

        //获取需要扫描包的路径
        String rootPath = dir.getAbsolutePath();

        try {
            findAllClassInPackageByFile(dir, sets, packageName, rootPath);
            return sets;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sets;

    }

    /**
     * 循环递归扫描一个文件夹下面的所有java类,并获取其Class字节码放入集合中
     *
     * @param dir         需要扫描的文件夹
     * @param sets        集合
     * @param packageName findClassesByPackage()方法传递过来的需要扫描的根包名
     * @param rootPath    packageName根包名所对应的文件路径
     */
    private static void findAllClassInPackageByFile(File dir, Set<Class<?>> sets,
                                                    String packageName, String rootPath) throws ClassNotFoundException {
        if (dir.exists() && dir.isDirectory()) {
            File[] chirldFiles = dir.listFiles();
            for (File file : chirldFiles) {
                if (file.isDirectory()) {
                    findAllClassInPackageByFile(file, sets, packageName, rootPath);
                } else {
                    if (file.getName().endsWith(".class")) {
                        String subClassName = file.getName().replace(".class", "");

                        //获取类的绝对路径去掉.class后缀名
                        String classAbasolutePath = file.getAbsolutePath().replace(".class", "");
                        if (classAbasolutePath.equals(rootPath + "\\" + subClassName)) {
                            //扫描到的是需要扫描包下面的直接类

                            //把里面的"/"和"\"替换为"."
                            String clazzTemp = (packageName + "." + subClassName).replaceAll("/", "\\.");
                            Class<?> clazz = Class.forName(clazzTemp);
                            sets.add(clazz);
                        } else {
                            //扫描到的是需要扫描包下面的子包下面的类

                            //把里面的"/"和"\"替换为"."
                            String clazzTemp = (packageName + classAbasolutePath.substring(rootPath.length())) //
                                    .replaceAll("\\\\", "\\.").replaceAll("/", "\\.");
                            Class<?> clazz = Class.forName(clazzTemp);
                            sets.add(clazz);
                        }
                    }
                }

            }
        }
    }

    //	public static void main(String[] args) throws Exception {
    //		Set<Class<?>> sets = scanClassesByPackage("service");
    //		for (Class<?> cs : sets) {
    //			System.out.println(cs.getName());
    //		}
    //	}
}
