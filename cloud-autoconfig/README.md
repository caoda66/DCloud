#config client客户端自动刷新包
## 概述
```
 在使用spring-cloud-config时，当配置文件发生变化时,客户端需要手段刷新（
 调用/actuator/refresh），或者通过集成spring-cloud-bus由config server
 端手动统一刷新。
 本模块实现客户端自动刷新包，相关config client 引入依赖即可实现客户端自动刷新配置
```
## 使用
```aidl
       1.添加依赖包 
        <dependency>
            <groupId>org.cyd</groupId>
            <artifactId>cloud-autoconfig</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
       2.配置刷新频率
       cyd:
         cloud:
           config:
             refreshInterval: 5
```