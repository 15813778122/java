# 一、Maven简介

#### 1.1 在项目中如何导入jar包？

	- 下载jar包(mvn)
	- 将下载的jar包拷贝到项目中(lib)
	- 选择jar文件 - 右键 - Add as library

#### 1.2 传统导入jar包的方式存在什么问题？

- 步骤多(相对) - `繁琐`
- 在不同的项目中如果需要相同的jar包，需要分别存储这些jar文件 - `冗余`,`项目体积大`
- 在不同的环境中可能因为jar文件版本的不一致导致项目无法运行(重写配置) - `移植性差`

#### 1.3 项目生命周期

> 项目从编译到运行的整个过程
> 完整的生命周期：清理缓存 - 校验 - 编译 - 测试 - 打包 - 安装 - 部署

- IDEA提高了一键构造项目的功能，但是如果我们需要自定义的生命周期管理，却没有现成的工具(清理缓存)

#### 1.4 Maven简介

> Maven是一个`基于项目对象模型（POM）用于进行项目的依赖管理、生命周期管理的`工具软件

**核心功能**

- 项目的依赖(jar包)管理

- 项目生命周期管理

- 聚合工程



# 二、Maven安装及配置

#### 2.1 Maven下载

- https://maven.apache.org/download.cgi

#### 2.2 Maven安装

> Maven是基于Java语言进行开发的，因此依赖JDK（建议JDK1.7+）
>
> 开箱即用：直接解压即可

- 解压(d:/mvn)
- 目录结构：
  - bin 存放指令文件(Maven提供了一个mvn指令)
  - boot 包含了一个类加载框架的jar文件
  - conf  包含了Maven的核心配置文件settings.xml
  - lib 存放了maven运行所需的jar文件

#### 2.3 配置环境变量

- `MAVEN_HOME`		D:\Maven\apache-maven-3.8.4

- `Path` 增加%MAVEN-HOME%\bin

  | 测试                                                         |
  | ------------------------------------------------------------ |
  | ![image-20220217171145001](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220217171145001.png) |

  



# 三、Maven的项目结构

> 使用Maven进行项目还有一个好处：无论使用什么样的开发工具(eclipse/idea)项目的结构是统一的

#### 3.1 Maven的项目结构

```
fmwy(项目名称)
--src
  --main(存放项目的源文件)
    --java(存放java文件，相当于传统项目中的src目录)
    --resources(存放配置文件种静态资源的目录，相当于传统项目中的web目录)
  --test(存放项目中的单元测试代码)
  	--java(测试代码)
--pom.xml
```

#### 3.2 pom.xml

>POM Project Obejct Model（项目的对象模型文件），Maven可以根据pom文件的配置对此项目进行依赖管理；也就是说项目中需要依赖，直接在pom.xml进行配置即可

```xml
<?xml version="1.0" encoding="utf-8"?>
<Project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<!--指定项目模型版本-->
    <modelVesion>4.0</modelVesion>
    <!--指定项目的标识:G 企业表示 A 项目标识 V 版本-->
    <groupId>com.qfedu</groupId>
    <artifactId>fmwy</artifactId>
    <version>1.0.0</version>
    
    <!--配置当前项目的依赖-->
    <dependencies>
    
    </dependencies>
</Project>
```

> 如果需要在当前项目中添加依赖，只需在pom.xml文件中进行依赖配置即可

**配置依赖** 找到依赖的坐标，添加到dependencies标签即可

```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.16</version>
</dependency>
```





# 四、使用Maven进行依赖管理

#### 4.1 Maven依赖管理的流程

![image-20220221145514764](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221145514764.png)



#### 4.2 Maven仓库介绍

- `本地仓库` 就是本地计算机上的某个文件夹(可以是自定义的任何文件夹
- `远程仓库` 就是远程本地上的jar文件仓库
  - `中央仓库` maven官方提供的仓库，包含了所需的一切依赖(免配置)
  - `公共仓库` 除了中央仓库以外的第三方仓库都是公共仓库，例如aliyun(需要配置)
  - `私服` 企业搭建的供内部使用的maven仓库

| maven仓库                                                    |
| ------------------------------------------------------------ |
| ![image-20220221151026769](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221151026769.png) |

#### 4.3 Maven仓库配置

- 在maven_home/conf/settings.xml中进行配置

**配置本地仓库**

```xml
<localRepository>d:\repo</localRepository>
```

**配置公共仓库**

```xml
<mirror>
      <id>nexus-aliyun</id>
      <mirrorOf>central</mirrorOf>
      <name>Nexus aliyun</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public</url>
    </mirror>
</mirrors>
```



# 五、使用maven进行项目生命周期管理

#### 5.1 生命周期介绍

> 项目构建的生命周期：项目开发结束之后部署到运行环境运行的过程
>
> - 清除缓存
> - 检查
> - 编译（变成class文件）
> - 测试（就会执行maven项目中的test目录下的单元测试）
> - 打包（war、jar）
> - 安装（jar会被安装到本地仓库）
> - 部署/运行（将项目生成的包放到外部服务器中 - 私服仓库）

#### 5.2 生命周期管理指令

在项目的根目录下执行mvn指令（此目录下必须包含pom.xml）

- 清楚缓存

```
mvn clean
```

- 检查

```
mvn check
```

- 编译

```
mvn compile
```

- 测试

```
mvn test
```

- 打包

```
mvn package
```

- 安装

```
mvn install
```

- 部署

```
mvn deploye
```



# 六、基于IDEA的Maven使用

#### 6.1 在IDEA中关联Maven

| maven配置                                                    |
| ------------------------------------------------------------ |
| ![image-20220221160121155](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221160121155.png) |
| ![image-20220221155947153](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221155947153.png) |

`说明：` ；IDEA本身集成了Maven，考虑到IDEA和Maven版本的兼容性，Idea不建议配置比默认版本更高的版本，建议使用idea自带的maven。

#### 6.2 使用IDEA创建Maven项目

###### 6.2.1 Java项目

|                                                              |
| ------------------------------------------------------------ |
| ![image-20220221161446498](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221161446498.png) |
| ![image-20220221162407734](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221162407734.png) |
| ![image-20220221163011487](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221163011487.png) |

###### 6.2.2 Web项目

- **创建maven项目：maven-demo2**
- **在pom.xml文件设置打包方式为war**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.qfedu</groupId>
    <artifactId>MavenWebDemo</artifactId>
    <version>1.0.0</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <!--设置项目打包方式为war-->
    <packaging>war</packaging>

</project>
```

- **完善web项目结构**

![image-20220221170239732](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221170239732.png)

- **配置web组件-Tomcat**

![image-20220221170331088](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221170331088.png) 

![image-20220221170931806](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220221170931806.png)

- **部署项目**

![image-20220222211417807](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220222211417807.png)

![image-20220222211452146](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220222211452146.png)

#### 6.3 在IDEA中使用Maven进行依赖管理

###### 6.3.1 查找依赖坐标

- https://mvnrepository.com/

###### 6.3.2 添加依赖

- 将依赖的坐标配置到项目的pom.xml文件dependencies标签中

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.qfedu</groupId>
    <artifactId>maven-demo</artifactId>
    <version>1.0.0</version>
    <!--设计项目打包方式为war-->
    <packaging>war</packaging>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.8.6</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

</project>
```

###### 6.3.3 依赖范围

> 在通过dependency添加依赖时，可以通过`scope`标签配置当前依赖的适用范围

- test 只在项目测试阶段引入当前依赖（编译、测试）[比较常用]

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.1</version>
    <scope>test</scope>
</dependency>
```

- runtime 只在运行时使用（运行、测试运行）
- provided 在（编译、测试、运行）
- compile(或者把scope标签删除) 在（编译、测试、运行、打包）都引入 [比较常用]

#### 6.4 在IDEA中使用Maven进行项目构建

###### 6.4.1 Maven项目构建生命周期说明

- clean 清理缓存 清理项目生成的缓存
- validate 校验 验证项目需要是正确的（项目信息、依赖是否安装好）项目不会重新编译
- compile 编译 编译项目专供的源代码
- test 测试 运行项目中的单元测试
- package 打包 将项目编译后的代码打包成发布格式
- verify 检查 对集成测试的结果进行检查、确保项目的质量是达标的
- install 安装 将包安装到maven的本地仓库，以便在本地的其他项目中可以引用此项目（聚合工程）
- deploy 部署 将包安装到私服的仓库，以便其他开发人员共享

###### 6.4.2 IDEA进行生命周期管理

- 可视化

![image-20220224115005913](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220224115005913.png)

- 终端指令

选择项目名称---右键---Open in Terminal

mvn clean



# 七、私服

> 企业搭建供内部使用的一个Maven仓库
>
> - 开发者需要依赖直接从私服下载
> - 私服可以实现企业内部依赖的共享：当企业开发了一个通用的插件(jar)，可以发布到私服，可以连接到当前私服的其他开发者就可以共享这个插件了

#### 7.1 私服搭建

我们可以通过专门的Maven仓库管理软件来搭建私服。例如：Apache Archiva、Nexus

###### 7.1.1 下载Nexus

- 官网 https://www.sonatype.com/
- 下载 https://help.sonatype.com/repomanager2/download

###### 7.1.2 解压nexus

![image-20220225111750485](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220225111750485.png)

###### 7.1.3 安装并运行nexus

- 进入到`nexus-2.14.21-02/bin` 目录
- 管理员身份打开cmd命令行，执行指令

![image-20220225114132686](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220225114132686.png)

###### 7.1.4 登录Nexus

> 私服管理器登录地址：http://localhost:8081/nexus

![image-20220225114420884](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220225114420884.png)

- 私服中仓库类型

![image-20220225114835841](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220225114835841.png)

- 私服仓库组的配置

![image-20220225115424614](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220225115424614.png)

![image-20220225115645940](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220225115645940.png)

![image-20220225115717916](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220225115717916.png)



#### 7.2 配置私服

7.2.1 在maven的settings.xml文件的`servers`标签中

```xml
<!--配置连接私服所需的帐号和密码-->
<server> 
    <id>nexus-public</id> <!-- nexus的认证id -->
    <username>admin</username> <!--nexus中的用户名密码-->
    <password>admin123</password> 
</server>
```

###### 7.2.2 在maven的settings.xml文件的`profiles`标签中

> repository和pluginRepository的id子标签的值，要和上面配置的server的id子标签的值一致

```xml
<profile> 
    <id>nexus</id> 
    <repositories> 
        <repository> 
            <id>nexus-public</id>      
            <name>Nexus Release Snapshot Repository</name>   
            <url>http://localhost:8081/nexus/content/groups/public/</url>
            <releases><enabled>true</enabled></releases> 
            <snapshots><enabled>true</enabled></snapshots> 
        </repository>
    </repositories> 
    <pluginRepositories>
        <pluginRepository> 
            <id>nexus-public</id> 
            <url>http://localhost:8081/nexus/content/groups/public/</url>
            <releases><enabled>true</enabled></releases> 
            <snapshots><enabled>true</enabled></snapshots> 
        </pluginRepository> 
    </pluginRepositories> 
</profile>
```

###### 7.2.3 在maven的settings.xml文件的`activeProfiles`配置激活profile

```xml
<!--激活profiles,激活哪一个？就是profile的id的值-->
 <activeProfiles>
	<activeProfile>nexus</activeProfile>
 </activeProfiles>
```





# maven聚会工程搭建



# 八、使用IDEA的小技巧

#### 一. idea生成测试类快捷键

**1.选中你要测试的类名**

![image-20220224111439400](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220224111439400.png)

**2.按住Ctrl+Shift+T，弹出如下窗口选择Create New Test**

![image-20220224111518523](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220224111518523.png)

**3.选择你要测试的方法，点击OK**

![image-20220224111537479](C:\Users\HP\AppData\Roaming\Typora\typora-user-images\image-20220224111537479.png)