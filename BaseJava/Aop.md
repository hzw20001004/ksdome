AOP:
优点 代理,在某方法之前和之后可以执行其他动作 把程序的程序进行强化
各个步骤之间的良好隔离性
源代码无关性]

OOP（面向对象编程）针对业务处理过程的实体及其属性和行为进行抽象封装，以获得更加清晰高效的逻辑单元划分。

AOP利用一种称为“横切”的技术，剖解开封装的对象内部，并将那些影响了 多个类的公共行为封装到一个可重用模块，
并将其名为“Aspect”，即方面。所谓“方面”，简单地说，就是将那些与业务无关，却为业务模块所共同调用的 逻辑或责任封装起来，
比如日志记录，便于减少系统的重复代码，降低模块间的耦合度，并有利于未来的可操作性和可维护性

功能
连接点（joinPoint）: 在目标对象中，所有可以增强的方法。
切入点（pointCut）: 在目标对象中，已经增强的方法。
增强/通知（advice）: 增强的代码。
目标对象（target）: 被代理对象。
织入（weaving）: 将通知应用到到连接点。
代理（Proxy）: 将通知织入到目标对象形成代理对象。
切面（aspect）: 切入点+通知。

aspect：切面，通俗的讲可以理解为一个功能，比如具备某项能力(如：帮助他人是一种能力))，定义为一个切面；
pointCut：切点，可以理解为一种匹配规则，比如哪些人需要被帮助，通过一些规则进行分组筛选；
Target Object：目标对象，比如某种能力需要对某个人使用，这个某个人就是目标对象；
joinpoint：连接点，具体的需要做的事情，可以理解为需要使用某项能力帮助某人做什么事情的时候提供帮助；这个做什么事情就是连接点了；
Advice：回调的通知，比如：在什么时间点去帮助他们，在什么时间点提供某种能力帮助别人；