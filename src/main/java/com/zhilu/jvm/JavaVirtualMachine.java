package com.zhilu.jvm;

/**
 * @author apple
 * @version jdk1.8
 * <p>
 * 对于Java虚拟机的整个分析.
 *
 * 启动参数对Java进行调优.
 * 对于Java启动参数来说,它有三种启动参数类型{
 *     one   -> 标准化参数.    command -> java -help
 *     two   -> 非标准化参数.  command -> java -X
 *     three -> 非Stable参数. command -> java -XX:+PrintFlagsInitial or java -XX:+PrintFlagsFinal
 * }
 *
 * 第一种标准化参数(-),     对于所有的JVM来说,它都必须去实现所有标准化参数的功能.并且向后兼容.
 * 第二种非标准化参数(-X),  默认JVM都实现这些参数都功能,但是不能保证所有的JVM都实现满足,且不向后兼容.
 * 第三种非Stable参数(-XX),此类参数各个JVM实现都不同,而且在未来都版本中可能被取消,所有请谨慎使用改了参数.
 *
 * 对三种参数的部分参数案例{
 *    标准化参数{
 *        java -version 当前JVM的版本,JVM是哪个厂家提供的.
 *        java -server  设置JVM为server模式,虽然启动比较慢相较于-client.但是有更高的效率和内存管理机制,常使用于生产环境中.
 *        java -ea      在程序中使用断言.
 *        java -da      在程序中禁止使用断言.
 *        ...........................................
 *    }
 *    非标准化参数{
 *        java -Xms 初始化JVM堆的大小. 默认为当前物理内存的1/64, 最小为1M, 可指定单位K,M.如果不指定单位则默认的单位是字节
 *        java -Xmx 初始化JVM堆的最大的大小, 默认为当前物理内存的1/4或者1G. 最小为2M. 单位和-Xms一样.
 *        java -Xss 初始化JVM栈的大小
 *        java -Xnoclassgc 禁用类垃圾收集 可能会出现OutOfMemoryError
 *        .................................................
 *    }
 *   非Stable参数{
 *       可以分为下面三种:
 *       one -> 行为参数,用于改变jvm的一些基础行为{
 *           java -XX:-DisableExplicitGC 禁止程序调用System.gc(),但jvm的gc仍然有效.
 *           java -XX:+ScavengeBeforeFullGC 新生代GC优先于Full GC执行
 *           java -XX:+UseGCOverheadLimit 在抛出OOM之前限制jvm耗费在GC上的时间比例.
 *           java -XX:-UseConcMarkSweepGC 对老生代采用并发标记交换算法进行GC.
 *         .................................................
 *       }
 *
 *       two -> 性能参数,用于jvm的性能调优{
 *           java -XX:LargePageSizeInBytes=4m 设置用于Java堆的大页面尺寸
 *           java -XX:MaxHeapFreeRatio=70 GC后java堆中空闲量占的最大比例
 *           java -XX:ThreadStackSize=512 设置线程栈大小,若为0则使用系统默认值
 *           java -XX:MaxNewSize=size 新生成对象能占用内存的最大值
 *           java -XX:MaxPermSize=64m 老生代对象能占用内存的最大值
 *           .................................................
 *       }
 *
 *       three -> 调试参数,一般用于跟踪,打印,输出等jvm参数,用于显示jvm更加详细的信息{
 *           java -XX:-PrintGC    每次GC时打印相关信息
 *           java -XX:-PrintGCTimeStamps  打印每次GC的时间戳
 *           java -XX:-HeapDumpOnOutOfMemoryError 当首次遭遇OOM时导出此时堆中相关信息
 *           java -XX:-CITime 打印消耗在JIT编译的时间
 *           .................................................
 *       }
 *   }
 * }
 *
 *
 */
public class JavaVirtualMachine {

    public static void main(String[] args) {
        System.out.println("Hello, JavaVirtualMachine");
    }

}
