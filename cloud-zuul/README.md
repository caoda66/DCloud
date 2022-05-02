#zuul版本问题
### 1. errorController中无getErrorPath()方法
~~~
 解决方案：
     1.降版本
     2.添加BeanPostProcessor
~~~


### 2.Forwarding error Caused by:Load balancer doet not have avaliable server for client
~~~
  1.是eureka-client包与zuul包版本保持一直
~~~

#问题产生原因：版本问题
`springboot使用了2.6.7 版本中，已经删除了getErrorPath方法`