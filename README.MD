**耦合**
程序之间的依赖关系，包括类之间的依赖，方法之间的依赖。

解耦：降低程序之间的依赖关系，并不是完全消除依赖。

就比如上的jdbc代码，当我们编译的时候，如果没有mysql的驱动包，我们将无法通过编译期。独立性特别差。

实际开发中，我们应该做到编译器不依赖，运行期才依赖。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200507191219140.png)
对比一下，如果我们用下面的Class.forName的方式，这样相当于读取的是一个字符串。那么就会运行时异常。

解耦的思路：
第一步：用反射来创建对象，避免使用new关键字

```java
DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
Class.forName("com.mysql.cj.jdbc.Driver");
```

第二步：使用配置文件来获取创建的对象的全限定类名

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```
可以替换上面的com.mysql.cj.jdbc.Driver
