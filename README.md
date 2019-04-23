# 第一部分：对于事物的认知
我们处在一个神奇世界中，世界中存在很多的事物，事物之间存在着各种各样的关系。比如说宇宙中的各个星球，他们之间存在引力，使得他们之间运行轨道受到彼此的影响。再比如说存在着银行，我可以从银行贷款，而且我必须偿还贷款，如果我不偿还贷款我就会有麻烦。所以我们认为世界是由不同的事物以及事物与事物之间存在的联系构成。
# 第二部分：个人的思考
事物本身我们可以使用变量进行表示，事物之间的联系我们可以使用数学关系进行表达。所以整个世界我们使用变量和数学关系可以完整表达。
## 2.1 事物和关系的具体表达：
这部分没有想好
## 2.2现在编程方式以及个人思考：
首先举一个简单的例子：数据库里面存储着一个人的成绩，网页上有一个文本框，目标是让文本框显示那个人的成绩。
编写程序的话，大致是这个样子(不要过分强调细节，相当于伪代码)：
* 第一步，服务器端定义变量 int grade; grade =  exec( "select grade from t_student_grade")
* 第二步，服务器端socket.send(grade)
* 第三步，网页端接收到变量，int grade= socket.receive();
* 第四步，网页端设定文本框的值，setGradeTextValue(grade);

在整个过程中，涉及到了四个事物，数据库中的成绩，服务端变量grade,网页端变量grade,网页端成绩文本框grade,数据流动为：

* 数据库中的成绩----- ("select语句")---->服务端变量grade-----（socket.send,socket.receive）---->
* 网页端变量grade----(setGradeTextValue)----->网页端成绩文本框grade
* 我们将("select 语句"）成为f1,（socket.send,socket.receive）称作f2,(setGradeTextValue)称作f3.
* f1创造成了服务端变量grade，并且满足  服务端变量grade==数据库中的成绩
* f2创造成了网页端变量grade，并且满足  网页端变量grade==服务端变量grade
* f3创造了使得   网页端成绩文本框grade==网页端变量grade
* 由以上可知  f1(x)=x;     f2(x)=x;       f3(x)=x;    并且我们还可以推出  f3(f2(f1(x)))=x;
* 整体表达就是  网页端变量grade=f3(f2(f1(数据库中成绩)))。
* 在这个过程中，我们的目标是让文本框显示那个人的成绩，说白了就是寻找一个函数 f(x),使得  网页端成绩文本框=f(数据库成绩)。具体f是如何实现让   网页端成绩文本框=f(数据库成绩)的我们并不关心。到这里我们知道，f(x)=f3(f2(f1(x)));难道只有  f3(f2(f1(x))) 可以实现让网页成绩文本框显示数据库中成绩的方法吗，不是的。
* 假设f1(x)=2x；f2(x)=3x;  f3(x)=x/6;,   f(x)=f3(f2(f1(x))) 仍然满足，仍然可以让网页成绩文本框显示数据库中成绩。
* 现在我们知道 只要满足 f(x)=f1(f2(f3(f4(*))))=x，就可以实现我们预期的目标。
* sql数据库自动提供了上文中提到的  f1(x)，即  select gradle****。并且可以创造变量满足  变量==数据库中数据。当我们的电脑由网卡的时候，网卡自然提供了一个函数，就是上文中的f2.并且满足  f2(x)=x;f3就是javaScript中包含的一个非常简单的函数。
* 到这里我的意思主要想说，我们可以根据目标  f(x)=x;  很容易的构建出f3(f2(f1(x)))这样的函数调用链出来。
* 所以只要我们可以正确的描述事物和事物本身具有的函数以及事物之间的关系，那么我们就可以根据一定的数学规则构建出函数调用链出来。也就是说，，，

* 再举一个例子，假设现在存在一个数字 x= 3，我们有一个函数 f(x)=x+1; 这个函数可以让那个数字加1.假设有一个目标，让那个数字变成5。我们所能做的就是调用那个函数，我们将  n!f(x)代表函数f(x) 递归调用n次。那么对于f(x)=x+1,那么  n!f(x)=x+n;  n!f(3)=3+n=5;求解得到n=2;由于函数调用次数只能为自然数。所以我们也可以知道目标为3.5的话，是无法实现的。

* 首先我们将  
*					n!f(x)代表函数f(x) 递归调用n次，
*        并且定义对于任意的函数，f(x),无论其函数的表达形式是怎样的，我们定义0!f(x)=x;
*        意思就是一个变量不经过任何的函数调用，那么它将保持自身的值不发生变化，这样的定义是合理的。

* 假设在一个问题中，所有的函数f1(x),f2(x),f3(x)*fn(x).都可以转换为一个单纯的数学函数，我们想要实现的函数成为Fdestination(x);
* 如果对于要实现的函数存在解，那么一定可以表达成这种形式。
* 					Fdestination(x)=  m1!f1(m2!f2(m3!f3(*mx1!f1(mx2!f2(mx3!f3(***))) 
* 其中m1，m2，m3,,,,,,mx1,mx2,mx3都是变量。给定一个具体的问题，怎么求解这些变量呢，肯定是有方法的，我们先将这种方法称为 方法a.

* 举一个带有判断条件的例子：存在一个变量 x=-1，目标是-2;*
* 函数
```c
int F1(x)
{
If(x>0)
	Return -x;
Else
	Retntu x;
}

int F2()
{
Return x+1;
}
```
* 如何通过 f1,f2的函数调用来实现-1-> -2的转变呢。这个很容易，答案是  Fdestination(-1)=F1(3!F2(-1))=-2;
* 带有判断条件了，一个程序函数就无法转换为一个单纯的数学函数了，但是可以转换为两个待条件的单纯的数学函数，
 *  F11(x)=-x(x>0);  F12(x)=x;(x<=0)

* 核心思想就是对于带有条件的函数，先将条件作为目标，然后再将条件函数作为普通函数通过方法a进行函数路径求解。


## 2.3理想中的编程语言。
* 理想中的编程语言，我认为理想中的编程语言应该是分为两部分，其中一部分包含了数学知识，另一部分，说清楚一个东西是什么就可以了，还有我想要达成的目标就足够了。至于如何达成目标的问题，这个问题，数学可以回答。如今我们的编程语言过多的描述了怎么做的问题，其实，其中很大一部分代码的逻辑非常简单，这种等级的代码其实可以很容易自动构建出来，我们可以使用更加简单的方式去描述。

# 第三部分：第二代操作系统构想：
## 1.第二代操作应该是这样子的，
* 一个包含了很多数学知识的函数执行路径构建器。一种正确描述事物，以及事物之间关系的方式，以及我们想要达成的目标。就足够了。函数执行路径构建器可以在输入目标的情况下输出实现目标的方法。这个样子的话，我们是有可能做到经得起数学证明的0bug的软件的。


