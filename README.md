# 分享知识 传递快乐

<br>

## Spring MVC Task定时任务

<br>
### @Scheduled 注解说明

> fixedDelay：上次任务结束后再次执行；执行一些需要周期性(有一定的循环规律)执行的代码,每隔指定 秒就会被调用，指定秒的间隔是指从上一次调用的完成之时开始算起。<br><br>
fixedRate：固定时间执行一次；执行一些需要定期执行的代码,每隔 5 秒就会被调用,此时的 5 秒就是从上一次调用之始开始算起了。<br><br>
cron：如果这些内置的属性还满足不了你的需求的话，那你可以通过 cron 表达式来指定你代码的执行时间。例如：在某个工作日或时间里执行。<br>



<br>

在xml里加入task的命名空间

```
xmlns:task="http://www.springframework.org/schema/task"   
http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.1.xsd  
```

配置扫描任务位置

```
<!-- 扫描任务 -->
<context:component-scan base-package="com.xh.task.commons.task" />
```


启用注解驱动的定时任务

```
<task:annotation-driven/> 
```

配置定时任务的线程池

```
<task:annotation-driven scheduler="myTask" />
<task:scheduler id="myTask" pool-size="5" />
```



注意事项：<br>

> (1)spring的@Scheduled注解  需要写在实现方法上<br><br>
(2)定时器的任务方法不能带有入参，也不能有返回值（如果有返回值，spring初始化的时候会告诉你有个错误、需要设定一个proxytargetclass的某个值为true），如果方法需要和其他应用层的对象进行交互的话，应该使用依赖注入的方式来访问。<br><br>
(3)实现类上要有组件的注解@Component<br>

<br><br>

### cron的配置说明

```
字段      允许值     允许的特殊字符
秒       0-59        , - * /
分       0-59        , - * /
小时      0-23        , - * /
日期      1-31        , - * ? / L W C
月份      1-12 或者 JAN-DEC     , - * /
星期      1-7 或者 SUN-SAT      , - * ? / L C #
年（可选）       留空, 1970-2099       , - * /
```
<br>

#### 例：

```
CRON表达式         含义 
"0 0 12 * * ?"    每天中午十二点触发 
"0 15 10 ? * *"    每天早上10：15触发 
"0 15 10 * * ?"    每天早上10：15触发 
"0 15 10 * * ? *"    每天早上10：15触发 
"0 15 10 * * ? 2005"    2005年的每天早上10：15触发 
"0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发 
"0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发 
"0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 
"0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发 
"0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发 
"0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发 
```



<br><br><br>

---

**如有不足或新的想法请留言--分享知识 传递快乐。** 