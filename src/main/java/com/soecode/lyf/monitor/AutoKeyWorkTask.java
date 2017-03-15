package com.soecode.lyf.monitor;

import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.common.base.Throwables;
import com.sun.management.OperatingSystemMXBean;

import sun.management.ManagementFactoryHelper;

/**
 * 自动增加关键字 Created by winston.wang on 16/7/9.
 */
@Service
public class AutoKeyWorkTask {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	 @Scheduled(cron = "0/15 * * * * ?")
	// 需要注意@Scheduled这个注解，它可配置多个属性：cron\fixedDelay\fixedRate
	public void autotask() {
		 logger.info("定时任务开始执行------执行周期：0 0/1 * * * ?");
	        StringBuilder sb = new StringBuilder();
	        sb.append("\n==========================通过java来获取相关系统状态========================== ");
	        sb.append("\n总的内存量: " + (Runtime.getRuntime().totalMemory() / 1024));//Java 虚拟机中的内存总量,以字节为单位
	        sb.append("\n空闲内存量: " + (Runtime.getRuntime().freeMemory() / 1024));//Java 虚拟机中的空闲内存量
	        sb.append("\n最大内存量: " + (Runtime.getRuntime().maxMemory() / 1024));

	        //获取操作系统相关信息
	        sb.append("\n=============================获取操作系统相关信息============================ ");
	        OperatingSystemMXBean osm = (OperatingSystemMXBean) ManagementFactoryHelper.getOperatingSystemMXBean();
	        sb.append("\n" + osm.getFreeSwapSpaceSize() / 1024);
	        sb.append("\n" + osm.getFreePhysicalMemorySize() / 1024);
	        sb.append("\n" + osm.getTotalPhysicalMemorySize() / 1024);
	        sb.append("\narch: " + osm.getArch());
	        sb.append("\navailableProcessors: " + osm.getAvailableProcessors());
	        sb.append("\ncommittedVirtualMemorySize: " + osm.getCommittedVirtualMemorySize());
	        sb.append("\nname: " + osm.getName());
	        sb.append("\nprocessCpuTime: " + osm.getProcessCpuTime());
	        sb.append("\nversion: " + osm.getVersion());
	        //获取整个虚拟机内存使用情况
	        sb.append("\n==========================获取整个虚拟机内存使用情况=========================== ");
	        MemoryMXBean mm = ManagementFactoryHelper.getMemoryMXBean();
	        sb.append("\nheapMemoryUsage: " + mm.getHeapMemoryUsage());
	        sb.append("\nnonHeapMemoryUsage: " + mm.getNonHeapMemoryUsage());
	        //获取各个线程的各种状态，CPU 占用情况，以及整个系统中的线程状况
	        sb.append("\n============获取各个线程的各种状态，CPU 占用情况，以及整个系统中的线程状况========== ");
	        ThreadMXBean tm = ManagementFactoryHelper.getThreadMXBean();
	        sb.append("\nthreadCount: " + tm.getThreadCount());
	        sb.append("\npeakThreadCount: " + tm.getPeakThreadCount());
	        sb.append("\ncurrentThreadCpuTime: " + tm.getCurrentThreadCpuTime());
	        sb.append("\ndaemonThreadCount: " + tm.getDaemonThreadCount());
	        sb.append("\ncurrentThreadUserTime: " + tm.getCurrentThreadUserTime());

	        //当前编译器情况
	        sb.append("\n=================================当前编译器情况============================= ");
	        CompilationMXBean gm = ManagementFactoryHelper.getCompilationMXBean();
	        sb.append("\nname: " + gm.getName());
	        sb.append("\ntotalCompilationTime: " + gm.getTotalCompilationTime());

	        //获取多个内存池的使用情况
	        sb.append("\n=========================获取多个内存池的使用情况============================ ");
	        List<MemoryPoolMXBean> mpmList = ManagementFactoryHelper.getMemoryPoolMXBeans();
	        for (MemoryPoolMXBean mpm : mpmList) {
	            sb.append("\nusage: " + mpm.getUsage());
	            sb.append("\nmemoryManagerNames: " + mpm.getMemoryManagerNames().toString());
	        }
	        //获取GC的次数以及花费时间之类的信息
	        sb.append("\n=====================获取GC的次数以及花费时间之类的信息======================== ");
	        List<GarbageCollectorMXBean> gcmList = ManagementFactoryHelper.getGarbageCollectorMXBeans();
	        for (GarbageCollectorMXBean gcm : gcmList) {
	            sb.append("\nname: " + gcm.getName());
	            sb.append("\nmemoryPoolNames: " + gcm.getMemoryPoolNames());
	        }
	        //获取运行时信息
	        sb.append("\n=============================获取运行时信息================================== ");
	        RuntimeMXBean rmb = ManagementFactoryHelper.getRuntimeMXBean();
	        sb.append("\nclassPath: " + rmb.getClassPath());
	        sb.append("\nlibraryPath: " + rmb.getLibraryPath());
	        sb.append("\nvmVersion: " + rmb.getVmVersion());

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        logger.info("当前时间{}, 系统信息如下:{}", dateFormat.format(new Date()), sb.toString());
	}
}
