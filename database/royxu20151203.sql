/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : royxu

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-12-03 14:46:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `roy_attachment`
-- ----------------------------
DROP TABLE IF EXISTS `roy_attachment`;
CREATE TABLE `roy_attachment` (
  `attachment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件主键id',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志位',
  `file_path` text COMMENT '文件路径',
  `file_type` varchar(100) DEFAULT NULL COMMENT '文件类型',
  `new_name` varchar(1024) DEFAULT NULL COMMENT '新文件名',
  `original_name` varchar(1024) DEFAULT NULL COMMENT '原文件名',
  `related_id` varchar(100) DEFAULT NULL COMMENT '附件关联id',
  `table_of_attachment` varchar(100) DEFAULT NULL COMMENT '附件所属表',
  `file_size` varchar(50) DEFAULT NULL COMMENT '文件大小',
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_attachment
-- ----------------------------
INSERT INTO `roy_attachment` VALUES ('1', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021415055959.jpg', 'image/jpeg', 'course_201511021415055959.jpg', '外卖6.jpg', '201511011547153860', 'roy_course', '90232');
INSERT INTO `roy_attachment` VALUES ('2', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/homework_201511021435585911.jpg', 'image/jpeg', 'homework_201511021435585911.jpg', '外卖3.jpg', '201511021435329104', 'roy_homework', '37312');
INSERT INTO `roy_attachment` VALUES ('3', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/homework_201511021435585366.jpg', 'image/jpeg', 'homework_201511021435585366.jpg', '外卖4.jpg', '201511021435329104', 'roy_homework', '65440');
INSERT INTO `roy_attachment` VALUES ('4', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/homework_201511021436229048.doc', 'application/msword', 'homework_201511021436229048.doc', '新建 Microsoft Word 文档.doc', '201511021435599671', 'roy_homework', '1825792');
INSERT INTO `roy_attachment` VALUES ('5', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/info_20151102144103256.jpg', 'image/jpeg', 'info_20151102144103256.jpg', '头像.jpg', '201511021359197754', 'roy_basic_info', '5756');
INSERT INTO `roy_attachment` VALUES ('6', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504351078.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504351078.ppt', '0 软件测试：课程总体介绍.ppt', '1', 'roy_course', '4014592');
INSERT INTO `roy_attachment` VALUES ('7', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504356836.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504356836.ppt', '1 软件测试：引论.ppt', '1', 'roy_course', '1707520');
INSERT INTO `roy_attachment` VALUES ('8', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504355916.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504355916.ppt', '2 软件测试：缺陷与软件质量.ppt', '1', 'roy_course', '1495552');
INSERT INTO `roy_attachment` VALUES ('9', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504355868.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504355868.ppt', '3 软件测试：测试相关概念.ppt', '1', 'roy_course', '3247616');
INSERT INTO `roy_attachment` VALUES ('10', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504355400.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504355400.ppt', '4 软件测试：软件测试方法概述.ppt', '1', 'roy_course', '1427968');
INSERT INTO `roy_attachment` VALUES ('11', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504353102.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504353102.ppt', '5 软件测试：白盒测试方法.ppt', '1', 'roy_course', '1544704');
INSERT INTO `roy_attachment` VALUES ('12', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504354682.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504354682.ppt', '6 软件测试：黑盒测试方法.ppt', '1', 'roy_course', '4638720');
INSERT INTO `roy_attachment` VALUES ('13', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504354596.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504354596.ppt', '7 软件测试：黑盒测试方法(其它）.ppt', '1', 'roy_course', '1540608');
INSERT INTO `roy_attachment` VALUES ('14', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504354958.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504354958.ppt', '8 软件测试：单元测试.ppt', '1', 'roy_course', '1918464');
INSERT INTO `roy_attachment` VALUES ('15', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504355158.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504355158.ppt', '9 软件测试：集成测试.ppt', '1', 'roy_course', '1822720');
INSERT INTO `roy_attachment` VALUES ('16', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504352472.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504352472.ppt', '10 软件测试：系统测试.ppt', '1', 'roy_course', '13570560');
INSERT INTO `roy_attachment` VALUES ('17', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_201511021504356843.ppt', 'application/vnd.ms-powerpoint', 'course_201511021504356843.ppt', '11 软件测试：软件测试评估.ppt', '1', 'roy_course', '578048');
INSERT INTO `roy_attachment` VALUES ('18', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/course_20151102150435267.doc', 'application/msword', 'course_20151102150435267.doc', '软件测试练习题 - 副本.doc', '1', 'roy_course', '34304');
INSERT INTO `roy_attachment` VALUES ('19', '0', '/home/lh/development/tomcat7/webapps/tist/attachment/info_201511041821555709.jpg', 'image/jpeg', 'info_201511041821555709.jpg', '徐老师2.jpg', '201511021359100630', 'roy_basic_info', '59884');

-- ----------------------------
-- Table structure for `roy_award`
-- ----------------------------
DROP TABLE IF EXISTS `roy_award`;
CREATE TABLE `roy_award` (
  `award_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '荣誉主键id',
  `award_date` varchar(30) DEFAULT NULL COMMENT '颁发日期',
  `award_name` varchar(1024) DEFAULT NULL COMMENT '荣誉名称',
  `award_rank` varchar(30) DEFAULT NULL COMMENT '荣誉级别',
  `award_unit` varchar(1024) DEFAULT NULL COMMENT '颁发单位',
  `user_no` varchar(50) DEFAULT NULL COMMENT '所属人员编号',
  PRIMARY KEY (`award_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_award
-- ----------------------------
INSERT INTO `roy_award` VALUES ('1', '2002-09-21', '先进党员', '校级', '南京晓庄学院', '201511021359100630');
INSERT INTO `roy_award` VALUES ('2', '2009-12-23', '先进教师', '校级', '南京晓庄学院', '201511021359100630');
INSERT INTO `roy_award` VALUES ('3', '2014-10', '优秀导师', '院级', '信息工程学院', '201511021359100630');
INSERT INTO `roy_award` VALUES ('4', '2002-10-20', '优秀讲师', '校级', '南京晓庄学院', '201511021359197754');
INSERT INTO `roy_award` VALUES ('5', '2009-11-15', '优秀党员', '校级', '南京晓庄学院', '201511021359197754');

-- ----------------------------
-- Table structure for `roy_basic_info`
-- ----------------------------
DROP TABLE IF EXISTS `roy_basic_info`;
CREATE TABLE `roy_basic_info` (
  `increment_id` varchar(30) NOT NULL COMMENT '自增id',
  `academic` varchar(100) DEFAULT NULL COMMENT '学历',
  `address` varchar(1024) DEFAULT NULL COMMENT '联系地址',
  `birthday` varchar(30) DEFAULT NULL COMMENT '出生年月',
  `detail_introduction` text COMMENT '详细介绍',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `en_introduction` text COMMENT '英文简介',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `pro_title` varchar(255) DEFAULT NULL COMMENT '职称',
  `zh_introduction` text COMMENT '中文简介',
  `member_site` varchar(1024) DEFAULT NULL COMMENT '成员个人主页',
  `member_sort` int(11) DEFAULT NULL COMMENT '成员顺序',
  `member_type` varchar(30) DEFAULT NULL COMMENT '成员类型',
  `research_area` varchar(255) DEFAULT NULL COMMENT '研究方向',
  `en_name` varchar(50) DEFAULT NULL COMMENT '英文名',
  `member_role` varchar(1024) DEFAULT NULL COMMENT '项目组承担角色',
  `email_validated` varchar(255) DEFAULT '‘未验证’' COMMENT '邮箱是否验证',
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_basic_info
-- ----------------------------
INSERT INTO `roy_basic_info` VALUES ('201511021359100630', '本科', '南京晓庄学院方山校区 鹤琴楼309', '1972-09-12', '详细介绍<br>', 'xujiaxi@126.com', '<p>Senior Engineer in School of  Information Technology of Nanjing Xiaozhuang University. </p><p>His research interest is software testing, especially embedded software testing and open source software testing</p>', '男', '徐家喜', '高级工程师', '<p>男，1972年12月-，毕业于南京大学，电子与微机应用专业，现专业技术职务为高级工程师。<br/></p>', '#', '0', '老师', ' 软件测试', 'roy', '项目主持', '未验证');
INSERT INTO `roy_basic_info` VALUES ('201511021359197754', '研究生', '南京晓庄学院方山校区 鹤琴楼微软中心', '1971-10-01', '王小正的详细介绍<br>', 'wangxiaozheng@126.com', 'Xiaozheng Wang\'s English Introduction<br>', '男', '王小正', '高级工程师', '王小正的中文简介<br>', '#', '1', '老师', 'WEB开发', 'Peter', 'CFO', null);
INSERT INTO `roy_basic_info` VALUES ('201511051956413311', '', '', '', '', '', '', '', '王燕', '', '', '', '3', '老师', '', null, null, '');
INSERT INTO `roy_basic_info` VALUES ('201511051959485503', '', '', '', '', '', '', '', '杨鑫', '', '', '', '5', '老师', '', null, null, '');
INSERT INTO `roy_basic_info` VALUES ('201511052000060576', '', '', '', '', '', '', '', '包衣勤', '', '', '', '7', '老师', '', null, null, '');
INSERT INTO `roy_basic_info` VALUES ('201511052000168999', '', '', '', '', '', '', '', '侯青', '', '', '', '9', '老师', '', null, null, '');
INSERT INTO `roy_basic_info` VALUES ('201511052000294857', '', '', '', '', '', '', '', '周凯', '', '', '', '11', '老师', '', null, null, '');
INSERT INTO `roy_basic_info` VALUES ('201511052000449802', '', '', '', '', '', '', '', '张玲玲', '', '', '', '13', '老师', '', null, null, '');

-- ----------------------------
-- Table structure for `roy_course`
-- ----------------------------
DROP TABLE IF EXISTS `roy_course`;
CREATE TABLE `roy_course` (
  `course_id` varchar(30) NOT NULL COMMENT '课程主键id',
  `course_grades` varchar(1024) DEFAULT NULL COMMENT '授课年级',
  `course_length` varchar(30) DEFAULT NULL COMMENT '课时',
  `course_name` varchar(1024) DEFAULT NULL COMMENT '课程名称',
  `course_intro` longtext COMMENT '课程介绍',
  `course_outline` longtext COMMENT '课程大纲',
  `user_no` varchar(50) DEFAULT NULL COMMENT '所属人员编号',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_course
-- ----------------------------
INSERT INTO `roy_course` VALUES ('1', '2014级', '56', '软件测试', '', '', '201511021359100630');
INSERT INTO `roy_course` VALUES ('2', '2001~', '56', '单片机原理与应用', '<div>《单片机原理与应用》是一门工程性质很强的课程，其教学目的与任务是：通过实验，使学生掌握单片机的内部结构以及各部分工作原理、</div><div>8051程序设计方法以及单片机和简单外围接口芯片的接口方法，以便获得在专业领域内应用单片机进行简单应用的初步能力。通过实验，</div><div>培养学生观察现象，分析、解决实验中所遇到问题以及理论联系实际的能力，同时培养学生实事求是、严谨务实的素养与良好的工作习惯。</div>', '', '201511021359100630');
INSERT INTO `roy_course` VALUES ('201511011547153860', '2012', '50', 'JavaWeb', 'sss', '333333', '201511021359197754');

-- ----------------------------
-- Table structure for `roy_experience`
-- ----------------------------
DROP TABLE IF EXISTS `roy_experience`;
CREATE TABLE `roy_experience` (
  `experience_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '经历主键id',
  `experience_info` text COMMENT '经历简介',
  `experience_role` varchar(50) DEFAULT NULL COMMENT '角色',
  `time_period_end` varchar(30) DEFAULT NULL COMMENT '结束日期',
  `time_period_start` varchar(30) DEFAULT NULL COMMENT '开始日期',
  `user_no` varchar(50) DEFAULT NULL COMMENT '所属人员编号',
  PRIMARY KEY (`experience_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_experience
-- ----------------------------
INSERT INTO `roy_experience` VALUES ('1', '南京师专教院物理系五环应用电子研究所，科研生产', '研发工程师', '1997-08', '1992-09', '201511021359100630');
INSERT INTO `roy_experience` VALUES ('3', '南京晓庄学院教学', '教师', '-', '2000-09-01', '201511021359197754');
INSERT INTO `roy_experience` VALUES ('4', 'xxxxx大学就读研究生', '研究生', '1991-06-30', '1987-09-01', '201511021359197754');
INSERT INTO `roy_experience` VALUES ('5', '南京晓庄学院计算机实验中心', '实验教师', '2012-06', '1997-09', '201511021359100630');
INSERT INTO `roy_experience` VALUES ('6', '南京晓庄学院信息工程学院计算机实验中心、计算机应用研究所', '教师', '-', '2012-07', '201511021359100630');

-- ----------------------------
-- Table structure for `roy_group_member`
-- ----------------------------
DROP TABLE IF EXISTS `roy_group_member`;
CREATE TABLE `roy_group_member` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标志位',
  `member_gender` varchar(5) DEFAULT NULL COMMENT '成员性别',
  `member_name` varchar(35) DEFAULT NULL COMMENT '成员姓名',
  `member_password` varchar(255) DEFAULT NULL COMMENT '登陆密码',
  `member_site` varchar(1024) DEFAULT NULL COMMENT '成员个人主页',
  `member_sort` int(11) DEFAULT NULL COMMENT '成员顺序',
  `member_type` varchar(30) DEFAULT NULL COMMENT '成员类型',
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_group_member
-- ----------------------------
INSERT INTO `roy_group_member` VALUES ('1', '0', '男', '王小正', '123456', '#', '1', '老师');
INSERT INTO `roy_group_member` VALUES ('2', '0', '男', '包依勤', '123456', '#', '5', '老师');
INSERT INTO `roy_group_member` VALUES ('3', '0', '女', '杨鑫', '123456', '#', '10', '老师');
INSERT INTO `roy_group_member` VALUES ('4', '0', '女', '张玲玲', '123456', '#', '15', '老师');
INSERT INTO `roy_group_member` VALUES ('5', '0', '女', '侯青', '123456', '#', '20', '老师');
INSERT INTO `roy_group_member` VALUES ('6', '0', '男', '学生1', '123456', '#', '100', '学生');
INSERT INTO `roy_group_member` VALUES ('7', '0', '男', '学生2', '123456', '#', '105', '学生');
INSERT INTO `roy_group_member` VALUES ('8', '0', '女', '学生3', '123456', '#', '110', '学生');
INSERT INTO `roy_group_member` VALUES ('9', '0', '女', '学生4', '123456', '#', '115', '学生');

-- ----------------------------
-- Table structure for `roy_homework`
-- ----------------------------
DROP TABLE IF EXISTS `roy_homework`;
CREATE TABLE `roy_homework` (
  `homework_id` varchar(30) NOT NULL COMMENT '作业主键id',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `del_flag` varchar(1) DEFAULT NULL COMMENT '删除标志位',
  `edit_time` varchar(30) DEFAULT NULL COMMENT '修改时间',
  `homework_name` varchar(1024) DEFAULT NULL COMMENT '作业名称',
  `homework_request` varchar(1024) DEFAULT NULL COMMENT '作业要求',
  `homework_course` varchar(1024) DEFAULT NULL COMMENT '所属课程',
  `user_no` varchar(50) DEFAULT NULL COMMENT '所属人员编号',
  PRIMARY KEY (`homework_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_homework
-- ----------------------------
INSERT INTO `roy_homework` VALUES ('201510051605408191', '2015-10-05 16:06:24', '0', '2015-10-31 23:03:01', '作业', '<p>作业要求1：2015年10月5日16:00:00前完成并上交；</p><p>作业要求2：保质保量完成。<br></p>', '计算机网络', '201511021359100630');
INSERT INTO `roy_homework` VALUES ('201510312301143963', '2015-10-31 23:01:32', '0', '2015-10-31 23:01:32', '作业2', '的发达', '单片机', '201511021359100630');
INSERT INTO `roy_homework` VALUES ('201511021435329104', '2015-11-02 14:35:58', '0', '2015-11-02 14:35:58', '1', '11111', 'JavaWeb', '201511021359197754');
INSERT INTO `roy_homework` VALUES ('201511021435599671', '2015-11-02 14:36:22', '0', '2015-11-02 14:36:27', '2', '222222222', 'JavaWeb', '201511021359197754');

-- ----------------------------
-- Table structure for `roy_paper`
-- ----------------------------
DROP TABLE IF EXISTS `roy_paper`;
CREATE TABLE `roy_paper` (
  `paper_id` varchar(30) NOT NULL COMMENT '文献主键id',
  `author` varchar(1024) DEFAULT NULL COMMENT '作者',
  `journal` varchar(1024) DEFAULT NULL COMMENT '发表期刊',
  `paper_abstract` varchar(1024) DEFAULT NULL COMMENT '文献摘要',
  `publish_time` varchar(30) DEFAULT NULL COMMENT '发表时间',
  `support_fund` varchar(1024) DEFAULT NULL COMMENT '支持资金',
  `title` varchar(100) DEFAULT NULL COMMENT '文献标题',
  `user_no` varchar(50) DEFAULT NULL COMMENT '所属人员编号',
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_paper
-- ----------------------------
INSERT INTO `roy_paper` VALUES ('201510021020311234', '梁轰,王江平,徐家喜', '电脑知识与技术', '摘要', '2015-06', '江苏省大学生创新项目', '基于Android的校园网站客户端的设计与实现', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201510030220124312', '梁轰,徐家喜,王江平', '南京晓庄学院学报', '摘要', '2014-12', '江苏省大学生创新项目', '公钥证书在Android APP访问校园网中的应用', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201510072130386174', '侯青, 徐家喜, 吉力', '电脑知识与技术', '针对传统海量数据存储和处理方法成本高、效率低、编写程序困难等缺点,该文搭建了基于Hadoop框架的云平台,设计和实现了基于Hadoop的校园教育资源管理系统。测试及实验结果表明,基于Hadoop的云平台在大数据和多用户并发访问环境下,系统运行稳定,数据处理快,能有效降低成本,较传统单机服务器具有明显优势,能够很好的在校园资源管理系统中得到应用。 更多还原', '2014-01', '南京晓庄学院科学研究项目', '基于Hadoop的校园教育资源管理系统', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201510072132318958', '王江平,徐家喜', '南京晓庄学院学报', '详细介绍了无线传感器网络的特点、面临的各种安全威协和安全目标.分析了目前已提出的无线传感器网络安全体系结构,并对它们的特性进行了比较.最后总结和讨论了无线传感器网络安全体系结构的研究方向. 更多还原', '2010-06', '南京晓庄学院培育项目(2010KYPY02)', '无线传感器网络安全体系结构分析', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201510072133403817', '徐家喜', '南京晓庄学院学报', '介绍了基于C8051F350单片机电阻测量系统的实现方法.重点给出了电阻测量系统的硬件和软件设计过程.该系统用C8051F350作为其核心,具有数据存储、与PC通信以及LCD显示等功能.使用结果表明,该系统软硬件设计完善,可靠性高,系统功耗低、精度高、使用方便. 更多还原', '2012-06', '无', '基于单片机C8051F350电阻测量系统的设计与实现', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201510072134279979', '徐家喜', '南京晓庄学院学报', '设计了一套基于Web的开放性实验管理系统,分析了系统的架构及主要功能模块,并对系统关键功能模块如:权限管理、word文档输出、实验日志管理、数据备份等实现作了详细介绍.系统运行结果表明,该设计提高了开放性实验管理的效率,方便了师生. 更多还原.', '2010-06', '南京晓庄学院院级教改项目(2009JYKT018)', '开放性实验管理系统的设计与实现', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201510072135207102', '王江平,徐家喜', '南京晓庄学院学报', '该文介绍光学脉冲磁场传感器的特点及实用化进程中存在的问题,理论分析了尺度因子对光学传感器测量精度的影响.通过对传统的尺度因子的计算算法进行改进,导出一般情况下尺度因子的理论表达式;提出提高光学脉冲磁场传感器尺度因子的方法:通过合理设置偏振角可以改变尺度因子进而提高光学脉冲磁场传感器的性能;实验测量出尺度因子的值,结果表明尺度因子理论值和实验测试数据可以保持一致. 更多还原', '2012-03', '国家自然科学基金(60472007)资助项目;南京晓庄学院培育项目(2010KYPY02)', '尺度因子对光学脉冲磁场传感器性能的影响', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201510072136139218', '徐家喜', '南京晓庄学院学报', '教学质量高低是教学活动的成效性外在表现形式 ,而良好的教学评价对教学质量有导向、促进、激励及调控功能。对教学活动的评价分析时常常遇到大量烦琐的数据计算 ,如 :标准分Z、标准差S、高分率等 ,而且查询修改起来十分不方便。为此 ,我们根据教学的具体情况和需求 ,建立了一套基于WIN/98/NT的教学评价管理系统 ,来管理数据资料、客观分析评估教学效果', '2000-04', '无', 'DELPHI语言在教学评价管理系统中的应用', '201511021359100630');
INSERT INTO `roy_paper` VALUES ('201511011545352642', '1', '1', '1', '1', '1', '1', '201511021359197754');

-- ----------------------------
-- Table structure for `roy_project_group`
-- ----------------------------
DROP TABLE IF EXISTS `roy_project_group`;
CREATE TABLE `roy_project_group` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `group_enintro` longtext COMMENT '英文介绍',
  `group_enname` varchar(1024) DEFAULT NULL COMMENT '项目组英文名',
  `group_zhintro` longtext COMMENT '中文介绍',
  `group_zhname` varchar(1024) DEFAULT NULL COMMENT '项目组中文名',
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_project_group
-- ----------------------------
INSERT INTO `roy_project_group` VALUES ('1', '<br>', '-', '<p><span style=\";font-family:Calibri;font-size:16px\">本项目组包括：</span></p><p><span style=\";font-family:Calibri;font-size:16px\">a)java<span style=\"font-family:宋体\">开发团队</span></span></p><p style=\"line-height: 1.5em;\"><span style=\"font-family: Calibri; font-size: 16px;\">使小组熟悉&nbsp;J2EE<span style=\"font-family: 宋体;\">大部分技术或产品，如：</span>Eclipse,&nbsp;EJB,&nbsp;Servlet/JSP,&nbsp;Struts,&nbsp;Spring,&nbsp;Hibernate,&nbsp;JSF,&nbsp;JUnit<span style=\"font-family: 宋体;\">等，熟悉流行的各应用服务器，如：</span>Tomcat,&nbsp;JBoss,Bean&nbsp;WebLogic,&nbsp;IBM&nbsp;WebSphere<span style=\"font-size: 16px; font-family: 宋体;\">，同时熟悉各种主流数据库（</span>Oracle<span style=\"font-size: 16px; font-family: 宋体;\">、</span>DB2<span style=\"font-size: 16px; font-family: 宋体;\">、</span>SQLServer<span style=\"font-size: 16px; font-family: 宋体;\">等）</span>,<span style=\"font-size: 16px; font-family: 宋体;\">熟悉主流的设计工具（</span>powerdesigner<span style=\"font-size: 16px; font-family: 宋体;\">）及设计&nbsp;思想（</span>AOP<span style=\"font-size: 16px; font-family: 宋体;\">），能开发流行的基于</span>B/S<span style=\"font-size: 16px; font-family: 宋体;\">结构的&nbsp;</span>n-Tier&nbsp;<span style=\"font-size: 16px; font-family: 宋体;\">系统，能够承接&nbsp;</span>IT&nbsp;<span style=\"font-size: 16px; font-family: 宋体;\">综合解决方案的开发。</span></span></p><p><span style=\";font-family:Calibri;font-size:16px\">b).NET<span style=\"font-family:宋体\">开发团队</span></span></p><p style=\"line-height:150%\"><span style=\"font-family: Calibri; font-size: 16px;\">使.NET<span style=\"font-family: 宋体;\">开发团队同样具备一定的设计建模能力，产品研发能力，熟练运用</span>PowerDesigner<span style=\"font-family: 宋体;\">等建模工具建模。能熟练运用</span>Visual&nbsp;Studio2005/2008/2010<span style=\"font-family: 宋体;\">，熟悉</span>XML<span style=\"font-family: 宋体;\">、</span>WebService<span style=\"font-family: 宋体;\">、</span>UDDI<span style=\"font-family: 宋体;\">等数据交互功能和分布式应用，能构建面向服务架构的应用体系架构</span>(SOA)<span style=\"font-family: 宋体;\">，对</span>AJAX<span style=\"font-family: 宋体;\">技术有非常深入的研究，能开发</span>RIA<span style=\"font-family: 宋体;\">方式的应用系统。</span></span></p><p><span style=\";font-family:Calibri;font-size:16px\">2<span style=\"font-family:宋体\">）研究方向</span></span></p><p style=\"line-height:150%\"><span style=\"font-family: Calibri; font-size: 16px;\">本团队结合“<span style=\"font-family: 宋体;\">江苏省基础教育资源网络化工程技术中心</span>”<span style=\"font-family: 宋体;\">建设，&nbsp;针对教育基础资源软件开发，在软件工程、软件质量、云计算以及人工智能等方面进行工程实践与理论研究。</span></span></p><p><br/></p>', '软件开发与新技术研究');

-- ----------------------------
-- Table structure for `roy_science_project`
-- ----------------------------
DROP TABLE IF EXISTS `roy_science_project`;
CREATE TABLE `roy_science_project` (
  `proj_id` varchar(30) NOT NULL COMMENT '项目主键id',
  `end_date` varchar(30) DEFAULT NULL COMMENT '结束日期',
  `my_work` varchar(1024) DEFAULT NULL COMMENT '我承担的工作',
  `proj_fund` varchar(30) DEFAULT NULL COMMENT '项目经费',
  `proj_info` text COMMENT '项目介绍',
  `proj_name` varchar(1024) DEFAULT NULL COMMENT '项目名称',
  `proj_origin` varchar(1024) DEFAULT NULL COMMENT '项目来源',
  `start_date` varchar(30) DEFAULT NULL COMMENT '开始日期',
  `user_no` varchar(50) DEFAULT NULL COMMENT '所属人员编号',
  PRIMARY KEY (`proj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_science_project
-- ----------------------------
INSERT INTO `roy_science_project` VALUES ('201510051554129617', '2015-10', '主持', '10万', '项目旨在设计开发一款实用性强，效率高的信息管理平台，提高工作效率，加强管理。', '科研项目1', '江苏省教育厅', '2014-10', '201511021359100630');
INSERT INTO `roy_science_project` VALUES ('201510072225250144', '2015-12', '主持', '5万', '开发基于SpringMVC+Hibernate+EasyUI的企业管理系统。', '科研项目2', '南京晓庄学院信息工程学院', '2014-09', '201511021359100630');
INSERT INTO `roy_science_project` VALUES ('201510072226357804', '2016-03', '主持', '20万', '开发基于SpringMVC+Hibernate+Bootstrap+Birt的动态报表管理系统。', '科研项目3', '南京晓庄学院', '2013-09', '201511021359100630');
INSERT INTO `roy_science_project` VALUES ('201511011546264153', '1', '1', '1', '1', '1', '1', '1', '201511021359197754');

-- ----------------------------
-- Table structure for `roy_student_project`
-- ----------------------------
DROP TABLE IF EXISTS `roy_student_project`;
CREATE TABLE `roy_student_project` (
  `stu_proj_id` varchar(30) NOT NULL COMMENT '项目主键id',
  `main_students` varchar(1024) DEFAULT NULL COMMENT '项目负责人',
  `proj_members` varchar(1024) DEFAULT NULL COMMENT '项目成员',
  `proj_results` text COMMENT '项目成果',
  `stu_proj_name` varchar(1024) DEFAULT NULL COMMENT '项目名称',
  `stu_proj_rank` varchar(30) DEFAULT NULL COMMENT '项目级别',
  `stu_proj_type` varchar(50) DEFAULT NULL COMMENT '项目类型',
  `teachers` varchar(1024) DEFAULT NULL COMMENT '指导老师',
  `user_no` varchar(50) DEFAULT NULL COMMENT '所属人员编号',
  PRIMARY KEY (`stu_proj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_student_project
-- ----------------------------
INSERT INTO `roy_student_project` VALUES ('201510051554378350', '季啸,何映蝶', '梁轰,袁春雷,黄会,黄天翔', '1、完成应用开发。\r\n2、申请相关软件著作权。\r\n3、发表1-2篇专业相关论文。', '基于Android的校园信息化平台设计与实现', '省级', '江苏省大学生创新项目', '王江平,徐家喜', '201511021359100630');
INSERT INTO `roy_student_project` VALUES ('201510072228082029', '梁轰', '无', '1、完成基于SpringMVC+EasyUI+Hibernate的权限管理系统的开发。\r\n2、撰写项目相关的专业论文。', '基于SpringMVC+EasyUI+Hibernate的权限管理系统', '校级', '指导项目', '徐家喜', '201511021359100630');
INSERT INTO `roy_student_project` VALUES ('201510072239324712', '梁轰', '无', '完成基于SpringMVC+Hibernate+Bootstrap的个人信息管理系统的平台开发。', '基于SpringMVC+Hibernate+Bootstrap的个人信息管理系统', '个人指导', '个人项目', '徐家喜', '201511021359100630');
INSERT INTO `roy_student_project` VALUES ('201511011546559079', '3', '3', '3', '3', '3', '3', '3', '201511021359197754');

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志位',
  `description` varchar(100) DEFAULT NULL COMMENT '数据字典配置项说明',
  `father_id` int(11) DEFAULT NULL COMMENT '所属父类id',
  `name` varchar(100) DEFAULT NULL COMMENT '数据字典配置项名称',
  `sort` varchar(10) DEFAULT NULL COMMENT '排序',
  `update_by` varchar(20) DEFAULT NULL COMMENT '修改者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_dict_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增编号',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `desciption` varchar(50) DEFAULT NULL COMMENT '数据字典描述',
  `dict_name` varchar(20) DEFAULT NULL COMMENT '数据字典名称',
  `update_by` varchar(20) DEFAULT NULL COMMENT '修改者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_email_random`
-- ----------------------------
DROP TABLE IF EXISTS `sys_email_random`;
CREATE TABLE `sys_email_random` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `is_validated` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否验证通过',
  `random_code` varchar(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '发给邮箱的验证码',
  `send_time` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '发送时间',
  `user_no` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户编号',
  `validate_time` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '验证时间',
  PRIMARY KEY (`increment_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of sys_email_random
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `exception` longtext COMMENT '异常信息',
  `method` varchar(10) DEFAULT NULL COMMENT '请求方法',
  `params` longtext COMMENT '请求参数',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '远端地址',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求uri',
  `type` char(10) DEFAULT NULL COMMENT '日志类型',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=284 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL COMMENT '菜单编号',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志位',
  `father_id` int(11) DEFAULT NULL COMMENT '父项菜单id',
  `href` varchar(255) DEFAULT NULL COMMENT 'url链接',
  `icon` varchar(100) DEFAULT NULL COMMENT '链接图片',
  `menu_level` varchar(10) DEFAULT NULL COMMENT '菜单级别',
  `menu_name` varchar(30) DEFAULT NULL COMMENT '菜单名称',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `sort` varchar(10) DEFAULT NULL COMMENT '排序',
  `update_by` varchar(20) DEFAULT NULL COMMENT '修改者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`),
  KEY `FK74A44791E63ED4D9` (`father_id`),
  CONSTRAINT `FK74A44791E63ED4D9` FOREIGN KEY (`father_id`) REFERENCES `sys_menu` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0', '超级管理员', '', '0', null, '#', '', '0', 'Royxu管理系统', '根菜单', '1.1', '', '');
INSERT INTO `sys_menu` VALUES ('1', '超级管理员', '', '0', '0', '#', null, '1', '系统功能', '', '10.5', '徐家喜', '2015-11-01 16:16:59');
INSERT INTO `sys_menu` VALUES ('2', '徐家喜', '2015-11-01 16:14:18', '0', '0', '/bjsp/index/myindex.jsp', null, '1', '我的主页', '', '10.1', '徐家喜', '2015-11-01 16:16:38');
INSERT INTO `sys_menu` VALUES ('3', '超级管理员', '2015-11-01 16:14:42', '0', '0', '#', null, '1', '个人信息管理', '', '10.2', '徐家喜', '2015-11-01 16:16:45');
INSERT INTO `sys_menu` VALUES ('4', '超级管理员', '2015-11-01 16:14:58', '0', '0', '#', null, '1', '教学管理', '', '10.3', '徐家喜', '2015-11-01 16:16:50');
INSERT INTO `sys_menu` VALUES ('5', '超级管理员', '2015-11-01 16:15:18', '0', '0', '#', null, '1', '项目组管理', '', '10.4', '徐家喜', '2015-11-01 16:16:54');
INSERT INTO `sys_menu` VALUES ('6', '徐家喜', '2015-11-01 16:21:59', '0', '0', '/bjsp/myaccount/myaccount.jsp', null, '1', '修改密码', '', '10.6', '徐家喜', '2015-11-01 16:21:59');
INSERT INTO `sys_menu` VALUES ('101', '超级管理员', '', '0', '1', '/jsp/menu/menu.jsp', '', '2', '菜单管理', '', '20.2', '超级管理员', '2015-06-01 13:26:16');
INSERT INTO `sys_menu` VALUES ('102', '超级管理员', '2015-06-01 13:04:07', '0', '1', '/jsp/role/role.jsp', '', '2', '角色菜单管理', '', '20.3', '超级管理员', '2015-06-01 13:45:56');
INSERT INTO `sys_menu` VALUES ('103', '超级管理员', '2015-06-01 13:12:55', '0', '1', '/jsp/user/user.jsp', '', '2', '用户管理', '', '20.1', '超级管理员', '2015-06-01 13:26:26');
INSERT INTO `sys_menu` VALUES ('104', '超级管理员', '2015-06-01 13:28:36', '0', '1', '/jsp/userrole/userrole.jsp', '', '2', '用户角色分配', '', '20.4', '超级管理员', '2015-06-01 13:29:00');
INSERT INTO `sys_menu` VALUES ('105', '超级管理员', '2015-06-02 15:55:50', '0', '1', '/jsp/codegenerate/codegenerate.jsp', '', '2', '代码生成器', '', '20.5', '超级管理员', '2015-06-02 15:55:50');
INSERT INTO `sys_menu` VALUES ('301', '徐家喜', '2015-11-01 16:18:12', '0', '3', '/bjsp/basicinfo/basicinfo.jsp', null, '2', '基本信息', '', '40.1', '徐家喜', '2015-11-01 16:18:12');
INSERT INTO `sys_menu` VALUES ('302', '徐家喜', '2015-11-01 16:18:34', '0', '3', '/bjsp/experience/experience.jsp', null, '2', '个人经历', '', '40.2', '徐家喜', '2015-11-01 16:18:34');
INSERT INTO `sys_menu` VALUES ('303', '徐家喜', '2015-11-01 16:18:51', '0', '3', '/bjsp/award/award.jsp', null, '2', '个人荣誉', '', '40.3', '徐家喜', '2015-11-01 16:18:51');
INSERT INTO `sys_menu` VALUES ('304', '徐家喜', '2015-11-01 16:19:10', '0', '3', '/bjsp/paper/paper.jsp', null, '2', '文献管理', '', '40.4', '徐家喜', '2015-11-01 16:19:10');
INSERT INTO `sys_menu` VALUES ('305', '徐家喜', '2015-11-01 16:19:35', '0', '3', '/bjsp/scienceproject/scienceproject.jsp', null, '2', '科研项目', '', '40.5', '徐家喜', '2015-11-01 16:19:35');
INSERT INTO `sys_menu` VALUES ('306', '徐家喜', '2015-11-01 16:19:53', '0', '3', '/bjsp/studentproject/studentproject.jsp', null, '2', '学生项目', '', '40.6', '徐家喜', '2015-11-01 16:19:53');
INSERT INTO `sys_menu` VALUES ('401', '徐家喜', '2015-11-01 16:20:17', '0', '4', '/bjsp/course/course.jsp', null, '2', '教学课程', '', '50.1', '徐家喜', '2015-11-01 16:20:17');
INSERT INTO `sys_menu` VALUES ('402', '徐家喜', '2015-11-01 16:20:32', '0', '4', '/bjsp/homework/homework.jsp', null, '2', '教学作业', '', '50.2', '徐家喜', '2015-11-01 16:20:32');
INSERT INTO `sys_menu` VALUES ('501', '徐家喜', '2015-11-01 16:20:55', '0', '5', '/bjsp/projectgroup/projectgroup.jsp', null, '2', '项目组基本信息', '', '60.1', '徐家喜', '2015-11-01 16:20:55');
INSERT INTO `sys_menu` VALUES ('502', '徐家喜', '2015-11-01 16:21:16', '0', '5', '/bjsp/groupmember/groupmember.jsp', null, '2', '项目组成员管理', '', '60.2', '徐家喜', '2015-11-01 19:52:34');

-- ----------------------------
-- Table structure for `sys_notice`
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` varchar(30) NOT NULL COMMENT '消息id',
  `author` varchar(20) DEFAULT NULL COMMENT '发布人',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志位',
  `notice_content` text COMMENT '消息内容',
  `notice_origin` varchar(255) DEFAULT NULL COMMENT '消息出处',
  `notice_time` varchar(30) DEFAULT NULL COMMENT '消息日期',
  `notice_title` varchar(200) DEFAULT NULL COMMENT '消息标题',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES ('201510271953417530', '', '0', '项目组于2015年10月28日在微软中进行一次会议交流', '', '2015-10-27 19:54:43', '会议讨论');
INSERT INTO `sys_notice` VALUES ('201510271954491931', '', '0', '项目组于2015年10月29日在微软中进行一次技术讲座', '', '2015-10-27 19:55:06', '技术讲座');
INSERT INTO `sys_notice` VALUES ('201510271955093498', '', '0', '项目组于2015年10月30日在微软中进行一次阶段总结', '', '2015-10-27 19:56:08', '阶段总结');
INSERT INTO `sys_notice` VALUES ('201510271955278706', '', '0', '项目组于2015年10月231日在微软中进行一次近阶段遇到的问题进行总结分析', '', '2015-10-27 19:56:00', '近期问题总结');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `menu_ids` text COMMENT '角色对应菜单id',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `update_by` varchar(20) DEFAULT NULL COMMENT '修改者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2015-06-01 17:00:38', '0,2,3,301,302,303,304,305,306,4,401,402,5,501,502,1,103,101,102,104,105,6', '超级管理员', '超级管理员', '徐家喜', '2015-11-01 16:24:38');
INSERT INTO `sys_role` VALUES ('2', '超级管理员', '2015-11-01 19:54:50', '0,2,3,301,302,303,304,305,306,4,401,402,6', '教师', '教师', '超级管理员', '2015-11-01 19:54:50');
INSERT INTO `sys_role` VALUES ('3', '超级管理员', '2015-11-01 19:55:21', '0,2,3,301,302,303,304,305,306,6', '学生', '学生', '超级管理员', '2015-11-01 19:55:21');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色菜单编号',
  `menu_father_id` varchar(255) DEFAULT NULL COMMENT '菜单父id',
  `menu_id` varchar(255) DEFAULT NULL COMMENT '角色对应菜单id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', 'null', '0', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '0', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('3', '0', '2', '1');
INSERT INTO `sys_role_menu` VALUES ('4', '0', '3', '1');
INSERT INTO `sys_role_menu` VALUES ('5', '0', '4', '1');
INSERT INTO `sys_role_menu` VALUES ('6', '0', '5', '1');
INSERT INTO `sys_role_menu` VALUES ('7', '0', '6', '1');
INSERT INTO `sys_role_menu` VALUES ('8', '1', '101', '1');
INSERT INTO `sys_role_menu` VALUES ('9', '1', '102', '1');
INSERT INTO `sys_role_menu` VALUES ('10', '1', '103', '1');
INSERT INTO `sys_role_menu` VALUES ('11', '1', '104', '1');
INSERT INTO `sys_role_menu` VALUES ('12', '1', '105', '1');
INSERT INTO `sys_role_menu` VALUES ('13', '3', '301', '1');
INSERT INTO `sys_role_menu` VALUES ('14', '3', '302', '1');
INSERT INTO `sys_role_menu` VALUES ('15', '3', '303', '1');
INSERT INTO `sys_role_menu` VALUES ('16', '3', '304', '1');
INSERT INTO `sys_role_menu` VALUES ('17', '3', '305', '1');
INSERT INTO `sys_role_menu` VALUES ('18', '3', '306', '1');
INSERT INTO `sys_role_menu` VALUES ('19', '4', '401', '1');
INSERT INTO `sys_role_menu` VALUES ('20', '4', '402', '1');
INSERT INTO `sys_role_menu` VALUES ('21', '5', '501', '1');
INSERT INTO `sys_role_menu` VALUES ('22', '5', '502', '1');
INSERT INTO `sys_role_menu` VALUES ('23', 'null', '0', '2');
INSERT INTO `sys_role_menu` VALUES ('24', '0', '2', '2');
INSERT INTO `sys_role_menu` VALUES ('25', '0', '3', '2');
INSERT INTO `sys_role_menu` VALUES ('26', '0', '4', '2');
INSERT INTO `sys_role_menu` VALUES ('27', '0', '6', '2');
INSERT INTO `sys_role_menu` VALUES ('28', '3', '301', '2');
INSERT INTO `sys_role_menu` VALUES ('29', '3', '302', '2');
INSERT INTO `sys_role_menu` VALUES ('30', '3', '303', '2');
INSERT INTO `sys_role_menu` VALUES ('31', '3', '304', '2');
INSERT INTO `sys_role_menu` VALUES ('32', '3', '305', '2');
INSERT INTO `sys_role_menu` VALUES ('33', '3', '306', '2');
INSERT INTO `sys_role_menu` VALUES ('34', '4', '401', '2');
INSERT INTO `sys_role_menu` VALUES ('35', '4', '402', '2');
INSERT INTO `sys_role_menu` VALUES ('36', 'null', '0', '3');
INSERT INTO `sys_role_menu` VALUES ('37', '0', '2', '3');
INSERT INTO `sys_role_menu` VALUES ('38', '0', '3', '3');
INSERT INTO `sys_role_menu` VALUES ('39', '0', '6', '3');
INSERT INTO `sys_role_menu` VALUES ('40', '3', '301', '3');
INSERT INTO `sys_role_menu` VALUES ('41', '3', '302', '3');
INSERT INTO `sys_role_menu` VALUES ('42', '3', '303', '3');
INSERT INTO `sys_role_menu` VALUES ('43', '3', '304', '3');
INSERT INTO `sys_role_menu` VALUES ('44', '3', '305', '3');
INSERT INTO `sys_role_menu` VALUES ('45', '3', '306', '3');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `bank_card` varchar(100) DEFAULT NULL COMMENT '银行卡号',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标志位',
  `department_id` varchar(64) DEFAULT NULL COMMENT '部门编号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `enter_time` varchar(30) DEFAULT NULL COMMENT '入职时间',
  `leave_time` varchar(30) DEFAULT NULL COMMENT '离职时间',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '登陆ip',
  `login_name` varchar(100) DEFAULT NULL COMMENT '登录名',
  `login_time` varchar(30) DEFAULT NULL COMMENT '登陆时间',
  `mobilephone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `phone` varchar(20) DEFAULT NULL COMMENT '家庭电话',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `update_by` varchar(20) DEFAULT NULL COMMENT '修改者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '修改时间',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `user_no` varchar(100) DEFAULT NULL COMMENT '员工编号',
  `user_password` varchar(24) DEFAULT NULL COMMENT '登陆密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, null, null, '0', null, null, null, null, null, 'admin', null, null, null, null, null, null, null, '超级管理员', null, 'admin');
INSERT INTO `sys_user` VALUES ('2', null, null, null, '0', null, null, null, null, null, 'xu', null, null, null, null, null, null, null, '徐家喜', '201511021359100630', '123456');
INSERT INTO `sys_user` VALUES ('3', null, '超级管理员', '2015-11-02 13:59:33', '0', null, null, null, null, null, 'wxz', null, null, null, null, null, null, null, '王小正', '201511021359197754', '123456');
INSERT INTO `sys_user` VALUES ('4', null, '徐家喜', '2015-11-05 19:57:25', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '王燕', '201511051956413311', '123456');
INSERT INTO `sys_user` VALUES ('5', null, '徐家喜', '2015-11-05 19:59:55', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '杨鑫', '201511051959485503', '123456');
INSERT INTO `sys_user` VALUES ('6', null, '徐家喜', '2015-11-05 20:00:10', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '包衣勤', '201511052000060576', '123456');
INSERT INTO `sys_user` VALUES ('7', null, '徐家喜', '2015-11-05 20:00:20', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '侯青', '201511052000168999', '123456');
INSERT INTO `sys_user` VALUES ('8', null, '徐家喜', '2015-11-05 20:00:34', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '周凯', '201511052000294857', '123456');
INSERT INTO `sys_user` VALUES ('9', null, '徐家喜', '2015-11-05 20:00:48', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, '张玲玲', '201511052000449802', '123456');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色自增id',
  `role_ids` varchar(255) DEFAULT NULL COMMENT '角色编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', 'admin');
INSERT INTO `sys_user_role` VALUES ('2', '1', '8', '徐家喜');
INSERT INTO `sys_user_role` VALUES ('3', '2', '9', '王小正');

-- ----------------------------
-- Table structure for `t_hat_area`
-- ----------------------------
DROP TABLE IF EXISTS `t_hat_area`;
CREATE TABLE `t_hat_area` (
  `id` int(11) NOT NULL,
  `area` varchar(255) DEFAULT NULL,
  `areaID` varchar(255) DEFAULT NULL,
  `father` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hat_area
-- ----------------------------

-- ----------------------------
-- Table structure for `t_hat_city`
-- ----------------------------
DROP TABLE IF EXISTS `t_hat_city`;
CREATE TABLE `t_hat_city` (
  `id` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `cityID` varchar(255) DEFAULT NULL,
  `father` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hat_city
-- ----------------------------

-- ----------------------------
-- Table structure for `t_hat_province`
-- ----------------------------
DROP TABLE IF EXISTS `t_hat_province`;
CREATE TABLE `t_hat_province` (
  `id` int(11) NOT NULL,
  `province` varchar(255) DEFAULT NULL,
  `provinceID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_hat_province
-- ----------------------------
