# java

> Java 学习工程：面向对象语法练习、Socket 聊天室、动态代理，外加 33 道力扣题

## 项目简介

这是我 2023 年 11 月到 2024 年 2 月学 Java 时的一个 IDEA 工程，`src` 下按「月份」和「主题」混着放了五六摊东西：

- **`JavaLearn/`**：面向对象入门练习，从类的定义、封装、继承、多态，一路到 `ArrayList`、`String`、`static`，最后是一个控制台版学生管理系统；
- **`month10` ~ `month12`**：跟着课程进度走的三个月的练习，主题是抽象类与接口、接口默认方法冲突、内部类、Socket 网络编程、动态代理；
- **`leetcode/`**：33 道力扣题的解法，命名风格是 `no_题号`，比另一个 `leetcode` 仓库那种 `No###` 的写法更早。

它不是一个能跑起来的「项目」，而是一个**学习过程的快照**：同一个知识点会有好几份 `demo1` ~ `demo13`，有写了一半的类（比如 `month10/demo1` 里空着的 `Swim` 接口），也有直接复制过来当草稿的力扣题解。所以下文的重点是把每个目录在练什么讲清楚，而不是假装它是一个完整的应用。

工程规模：111 个文件（其中 88 个 `.java`，约 3200 行代码），另有 2 个第三方 jar、14 个 `.idea` 配置文件和 1 个 `.iml`。

## 内容概览

### 按目录：每个目录在练什么

| 目录 | 文件数 | 在练什么 | 代表类 |
| --- | --: | --- | --- |
| `JavaLearn/learn1` | 4 | 类与对象、成员变量、构造方法 | `Role`（游戏角色，带随机攻击/受伤台词）、`phone` |
| `JavaLearn/learn2` | 2 | 封装、getter/setter、对象数组 + `Scanner` 录入 | `car` / `cartest` |
| `JavaLearn/learn3` | 2 | 对象数组的增删查、学号去重、数组扩容 | `Student` / `Test` |
| `JavaLearn/learn4` | 2 | 继承与方法重写 | `Employee` → `Teacher` |
| `JavaLearn/mystatic` | 2 | `static` 成员（全班共享 `teacherName`）、接收者参数 `show(Student this)` | `Student` / `test1` |
| `JavaLearn/opp` | 3 | 继承中的成员变量与构造方法调用顺序 | `Fu` / `Zi` / `Main` |
| `JavaLearn/多态` | 1 | `final` 方法不能被重写、多态调用 | `Fu` / `Zi` / `Test` |
| `JavaLearn/string` | 11 | `String` 不可变、`==` vs `equals`、`StringBuilder`、字符串反转/旋转、大小写转换、字符统计、用户登录校验 | `demo1` ~ `demo13`（无 demo2/3） |
| `JavaLearn/arraylist` | 8 | `ArrayList` 增删改查、按条件筛选、按 id 去重 | `demo1` ~ `demo5`、`Student`/`Phone`/`User` |
| `JavaLearn/studentSystem` | 4 | **控制台学生管理系统**（增删改查 + id 唯一校验）与**用户注册登录**（验证码、忘记密码） | `StudentSystem`、`app` |
| `month10/demo1` | 2 | 接口定义（`Swim` 是空接口，`Test` 是空类——**没写完**） | `Swim` |
| `month10/demo2` | 1 | 抽象类 + 接口的组合：`Person` → `Athlete`/`Coach` → 乒乓球/篮球的运动员与教练，`English` 接口只给乒乓球选手实现 | `pingpangAthlete`、`pingpangCoach` |
| `month10/demo3` | 3 | 接口 `default` 方法冲突（两个接口都有 `show()`，用 `Inter.super.show()` 指定）、接口静态方法、成员内部类/静态内部类、匿名内部类 | `Int`、`Outer`、`Main2` |
| `month11` | 1 | 力扣 238「除自身以外数组的乘积」的左右累乘写法 | `Solution.productExceptSelf` |
| `month12` | 5 | **Socket 聊天室**：`Server` + `Client`，登录/注册、用户名密码格式校验、多客户端广播、用户信息落盘到 `info.properties` | `Server`、`Client`、`MyRun` |
| `month12/day8` | 4 | **JDK 动态代理**：`Proxy.newProxyInstance` + `InvocationHandler`，在 `sing`/`dance` 前后插入日志 | `ProxyUtil`、`StudentInterface` |
| `leetcode` | 36 | 33 道力扣题（另有 `ListNode`、`TreeNode`、`Node` 三个节点类），2023/12—2024/1 写的 | 见下表 |

### `leetcode/` 子目录的 33 道题

| 主题 | 题号 |
| --- | --- |
| 链表 | 2 两数相加、19 删除倒数第 N 个结点、21 合并两个有序链表、24 两两交换、141 环形链表、142 环形链表 II、146 LRU 缓存、148 排序链表、160 相交链表、206 反转链表、234 回文链表 |
| 二叉树 | 94 中序遍历、98 验证 BST、101 对称二叉树、102 层序遍历、104 最大深度、105 前序+中序构造、114 展开为链表、199 右视图、226 翻转、230 第 K 小、437 路径总和 III、543 二叉树的直径 |
| 数组 / 矩阵 | 35 搜索插入位置、48 旋转图像、54 螺旋矩阵、73 矩阵置零、118 杨辉三角、189 轮转数组、240 搜索二维矩阵 II |
| 动态规划 | 70 爬楼梯 |
| 其他 | 138 随机链表的复制（`Node` 类）、108（内容实为 98，见「已知问题」） |

`no_146` 用了取巧写法：直接 `extends LinkedHashMap` 并重写 `removeEldestEntry`，靠 `accessOrder=true` 实现 LRU，这也是整个工程唯一触发 `unchecked` 编译警告的地方。

顺带一个可以佐证「这里只是随手练」的细节：`.idea/leetcode/statistics.xml` 里记录了 LeetCode 插件在这个工程上的统计——通过 35 题（简单 27 / 中等 8 / 困难 0），而 `src/leetcode` 里实际只有 33 个解法文件，说明有题目是写在这个工程之外、或者写完没保存下来的。

## 技术栈与运行方式

- **JDK 21（硬要求）**。依据是 `.idea/misc.xml` 的 `languageLevel="JDK_21"` / `project-jdk-name="21"`，以及 `java.iml` 里的 `<orderEntry type="jdk" jdkName="21" />`；代码本身也确实是按 21 写的：
  - `month12/Client.java`、`JavaLearn/studentSystem/StudentSystem.java`、`app.java` 大量使用 `switch` 箭头语法，要求 JDK 14+；
  - `leetcode/ListNode.java`、`TreeNode.java`、`no_2`、`no_21`、`no_206`、`no_234` 用了 `List.getFirst()` / `removeFirst()`（JDK 21 的 `SequencedCollection` API），要求 JDK 21。

  实测：`javac --release 21` 编译全量 0 错误；`--release 17` 会在 `no_21.java` / `ListNode.java` 报一串「找不到符号: 方法 getFirst()」。所以钉死 **JDK 21**，用 17 编不过。
- **构建工具：没有**。不是 Maven 也不是 Gradle 工程，`.idea/misc.xml` 里那几条 `maven_java/pom.xml`、`maven/pom.xml` 是 IDEA 从别的目录误带过来的残留配置，指向的路径在本仓库里并不存在（`maven_java/`、`maven/` 都没提交）。
- **第三方库**：`lib/commons-io-2.15.0.jar`、`lib/hutool-all-5.8.23.jar`，在 `java.iml` 里被声明为 project library。但 `grep -rn "cn.hutool\|org.apache.commons" src` **一处引用都没有**——这两个 jar 是为后面的 `puzzlegame` 准备的，在这个工程里是死重量（约 3 MB）。

命令行编译运行（在仓库根目录）：

```bash
# 编译全部（实测 JDK 21 下只有 1 条 unchecked 警告，0 错误）
javac -encoding UTF-8 -cp "lib/*" -d out $(find src -name "*.java")

# 跑控制台学生管理系统
java -cp out JavaLearn.studentSystem.StudentSystem

# 跑聊天室：先起服务端，再起一到多个客户端
java -cp out month12.Server
java -cp out month12.Client

# 跑动态代理
java -cp out month12.day8.test

# 跑某道力扣题（注意 leetcode 子目录里的类多数没有 main，需要自己加）
java -cp out leetcode.no_146
```

用 IDEA：`File → Open` 选仓库根目录即可，`java.iml` 已经把 `src` 标成 Sources Root、把 `lib/*.jar` 挂成依赖，直接右键任意 `main` 运行。

> 注意：`Server` 里读写用户信息用的是相对路径 `src/month12/info.properties`，**必须在仓库根目录下启动**，否则会 `FileNotFoundException`。

## 目录结构

```
java/
├── README.md
├── java.iml                    # IDEA 模块文件（JDK 21 + lib/*.jar）
├── name.txt                    # 一行测试数据：username=...&password=...&count=3
├── .gitignore                  # 只忽略 out/、bin/、.DS_Store，没忽略 .idea/
├── lib/
│   ├── commons-io-2.15.0.jar   # 未被引用
│   └── hutool-all-5.8.23.jar   # 未被引用
├── .idea/                      # 14 个文件，已入库（含 leetcode 插件统计）
└── src/                        # 88 个 .java，全部带 package 声明
    ├── JavaLearn/              # 语法练习，10 个子目录
    │   ├── learn1 ~ learn4/    # 类、封装、对象数组、继承
    │   ├── string/             # String/StringBuilder 练习 11 个 demo
    │   ├── arraylist/          # 集合练习 8 个文件
    │   ├── mystatic/  opp/  多态/
    │   └── studentSystem/      # 控制台学生管理 + 用户注册登录
    ├── month10/                # 抽象类、接口、内部类（demo1~demo3）
    ├── month11/                # 力扣 238
    ├── month12/                # Socket 聊天室（Server/Client）+ day8 动态代理
    │   ├── a.properties        # 遗留配置文件（class=month12.Student, method=study，无代码引用）
    │   ├── a.txt  info.properties
    └── leetcode/               # 33 道力扣题（no_题号）+ 3 个节点类
```

## 学习路线

按文件头注释里的 `@date` 排一遍，顺序非常清楚：

| 时间 | 阶段 | 内容 |
| --- | --- | --- |
| 无日期 | 语法起步 | `JavaLearn/`：类与对象 → 封装 → 继承 → 多态 → `String` → `ArrayList` → 学生管理系统。这一段没有 `@date` 注释，是最早写的，也还没养成用 IDEA 模板的习惯 |
| 2023/11 | 抽象与接口 | `month10/demo2` 抽象类 + 接口组合（运动员/教练），`demo3` 接口默认方法冲突、内部类、匿名内部类 |
| 2023/12（28 个文件） | 网络编程 + 力扣 | `month12` Socket 聊天室（登录注册、广播、`Properties` 落盘）、`month12/day8` 动态代理；同期开始写 `leetcode/` 的题（`no_2`、`no_146`、`no_148` 都在这段时间） |
| 2024/1—2 | 收尾 | `leetcode/` 剩下的树与链表题，`month11` 的每日一题 |

如果把 `JavaLearn` 当作第一部分，这个工程的路线恰好是「语法 → 面向对象 → 集合/字符串 → 接口与内部类 → 网络编程与反射 → 算法题」，是一条很标准的培训班/自学路径（包名 `com.heima` 出现在隔壁 `jedis` 仓库里，这套课程痕迹很明显）。

## 已知问题

- **没有构建脚本**：没有 `pom.xml` 也没有 `build.gradle`，无法 `mvn compile`；`lib/` 下的两个 jar 只能靠 IDEA 的模块配置挂上，命令行必须手写 `-cp "lib/*"`。要把这个工程给别人跑，得先补一个 `pom.xml` 或 `build.gradle`。
- **`lib/` 里的两个 jar 完全没被使用**：`commons-io` 和 `hutool` 在 `src` 里零引用，白白占了 3 MB 仓库体积。真正用到 hutool 的是隔壁 `puzzlegame`。
- **`.idea/` 和 `java.iml` 全部入库**（14 + 1 个文件）。`.gitignore` 里只写了 `out/`、`bin/`、`.DS_Store`，**漏了 `.idea/` 和 `*.iml`**——而隔壁 `leetcode` 仓库的 `.gitignore` 是写了的。入库的配置里还带着别人的路径痕迹：`editor.xml` 里全是 `$USER_HOME$/AppData/Local/Temp/leetcode/...`（Windows 路径），`misc.xml` 里指向不存在的 `maven_java/pom.xml`、`maven/pom.xml`，换台机器打开工程会有一堆无效配置。
- **`name.txt` / `month12/info.properties` 明文存了账号密码**（已处理）：原来是 `username=wjh&password=<真实密码>` 这种格式，`info.properties` 里还有三条明文口令。这两个文件已全部替换为占位数据（`admin` / `test` / `123456`）。注意 **git 历史里的旧内容仍然存在**，如果那个密码你还在别处使用，请直接更换密码，而不是只依赖这次清理。
- **`leetcode/no_108` 题号与内容不符**：文件名是 108（将有序数组转换为二叉搜索树），内容是 98（验证二叉搜索树），和 `no_98` 重复。更麻烦的是它的解法**是错的**——只比较了父子节点的直接大小关系，没有传递上下界，对 `[5,1,4,null,null,3,6]` 这种「孙子节点违反 BST 性质」的用例会误判为 `true`。`no_98` 里的中序遍历版本才是对的。
- **`month10/demo1` 是空壳**：`Swim` 是个空接口，`Test` 类里连 `main` 都没有，这个目录实际什么都没练到。
- **`month12/a.properties`、`a.txt` 是无主遗留文件**：`a.properties` 写着 `class=month12.Student` / `method=study`，但 `month12` 下并没有 `Student` 类（只有一个 `day8/Student`），而且 `grep -rn "a.properties"` 显示**没有任何代码读它**——应该是某次 Properties 练习留下的，可以直接删。
- **`month11/` 只有一个类、没有 `main`**：`Solution.productExceptSelf` 是纯方法，`Main` 里 `new Solution()` 调用后又把结果 `println` 在方法内部，属于边写边调试的痕迹，不能直接运行验证。
- **`JavaLearn/mystatic/Student.show(Student this)` 用了接收者参数（receiver parameter）**：语法合法（JDK 8+），但这是很少见的写法，容易被误认为写错；而且 `test1` 里 `import JavaLearn.arraylist.Student;` 之后又用全限定名 `JavaLearn.mystatic.Student`，说明当时被同名类搞混过。
- **`JavaLearn/studentSystem` 里有两套互不相干的 `main`**：`StudentSystem`（学生增删改查）和 `app`（用户注册登录 + 验证码），`app` 的菜单里有 `case "4" -> test(list)`，但菜单只打印了 1/2/3 三个选项，第 4 项是个没做完的测试入口。
- **无任何单元测试**：所有验证都靠 `main` 里 `System.out.println` 和肉眼比对，`Student`/`User`/`Phone` 这些实体类也没有测试覆盖。
- **命名不统一**：`JavaLearn` 用小驼峰（`phone`、`car`、`demo1`），`leetcode` 用 `no_题号`，`month12/day8` 里主类叫 `test`（小写）。工程里还混着中文包名 `JavaLearn/多态`，在部分工具链/CI 上会有编码问题。
