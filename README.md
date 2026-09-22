一、实验目的
 本实验学习 Android 多种布局，掌握 LinearLayout、TableLayout、ConstraintLayout 和 Jetpack Compose 的核心属性与机制，能按需选择布局实现界面，锻炼 Android UI 设计与开发实践能力。
 
二、实验环境
操作系统	Windows 11 Home China
开发工具	Android Studio 
编程语言	Java + Kotlin

三、实验内容
3.1 线性布局
利用LinearLayout实现一个4行4列的网格界面，通过weight（权重）属性控制各列的宽度比例，使不同行中各列的宽度比例可以不同。
3.2 表格布局
利用TableLayout实现一个菜单界面，包含标题行、菜单项（带快捷键）和分隔线，模拟文件操作菜单的外观。
3.3 约束布局1——计算器界面
利用ConstraintLayout实现一个计算器界面，包含标题栏、输入显示区和4x4的按钮矩阵（数字0-9、小数点、四则运算符及等号），通过约束链实现按钮的均匀排列。
3.4 约束布局2——太空旅行预订界面
利用ConstraintLayout实现一个太空旅行预订界面，包含顶部导航标签栏（Space Stations / Flights / Rovers）、出发地与目的地选择（DCA / MARS）、单程开关、乘客数量选择、中央插图和底部出发按钮。图片资源使用自定义drawable。
3.5 课程任务管理应用
使用Jetpack Compose实现一个课程学习任务管理应用，具有以下功能：初始状态显示3项任务（已完成1项）；支持添加新任务；勾选任务后完成数和删除线同步更新；支持删除任务。要求使用Column、Row、LazyColumn、remember、mutableStateOf等Compose核心API。

四、实验步骤和结果
4.1 线性布局


<img width="578" height="1229" alt="ScreenShot_2026-09-22_115735_570" src="https://github.com/user-attachments/assets/2b72991d-0c50-4c2e-b3d8-654e72bdd43a" />

4.2 表格布局


<img width="641" height="1253" alt="ScreenShot_2026-09-22_115755_310" src="https://github.com/user-attachments/assets/266e0354-de00-4c54-a7f4-20e97aabf867" />

4.3 约束布局1——计算器界面


<img width="574" height="1218" alt="ScreenShot_2026-09-22_115804_174" src="https://github.com/user-attachments/assets/44f8e95c-e448-4f63-9fd1-9f71469a1302" />


4.4 约束布局2——太空旅行预订界面


<img width="606" height="1218" alt="ScreenShot_2026-09-22_115812_627" src="https://github.com/user-attachments/assets/42e6cb55-ad53-4387-ae8d-55b3e81943d9" />


4.5 课程任务管理应用


<img width="583" height="1227" alt="ScreenShot_2026-09-22_115821_432" src="https://github.com/user-attachments/assets/dc62ae7b-ab1b-4670-a78c-37303564f3ab" />
<img width="739" height="1213" alt="ScreenShot_2026-09-22_115852_589" src="https://github.com/user-attachments/assets/4566a7fd-e3ac-4d6a-ae3b-fca259769dd7" />
<img width="614" height="1281" alt="ScreenShot_2026-09-22_115843_621" src="https://github.com/user-attachments/assets/f04649c4-4347-4737-b2a9-8cfa77a7a8e6" />

