/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : royxu

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-10-24 12:09:59
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_attachment
-- ----------------------------
INSERT INTO `roy_attachment` VALUES ('14', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/paper_201510051553153941.pdf', 'application/kswps', 'paper_201510051553153941.pdf', '公钥证书在Android APP访问校园网中的应用.pdf', '201510030220124312', 'roy_paper', '758376');
INSERT INTO `roy_attachment` VALUES ('15', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/scienceproj_201510051554308769.doc', 'application/msword', 'scienceproj_201510051554308769.doc', '（重点项目）（12数学与信息技术学院季啸 何映蝶）江苏省大学生创新项目申报书.doc', '201510051554129617', 'roy_science_project', '136704');
INSERT INTO `roy_attachment` VALUES ('16', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/stuproj_201510051554549542.doc', 'application/msword', 'stuproj_201510051554549542.doc', '（重点项目）（12数学与信息技术学院季啸 何映蝶）江苏省大学生创新项目申报书.doc', '201510051554378350', 'roy_student_project', '136704');
INSERT INTO `roy_attachment` VALUES ('17', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/homework_201510051606243419.exe', 'application/octet-stream', 'homework_201510051606243419.exe', 'genymotion.exe', '201510051605408191', 'roy_homework', '2712064');
INSERT INTO `roy_attachment` VALUES ('18', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/homework_201510052346254652.jpg', 'image/jpeg', 'homework_201510052346254652.jpg', '头像.jpg', '201510051605408191', 'roy_homework', '5756');
INSERT INTO `roy_attachment` VALUES ('19', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/paper_20151006011736823.caj', 'application/caj', 'paper_20151006011736823.caj', '基于Android的校园网站客户端的设计与实现_梁轰.caj', '201510021020311234', 'roy_paper', '2017070');
INSERT INTO `roy_attachment` VALUES ('20', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/course_201510231636365317.ppt', 'application/vnd.ms-powerpoint', 'course_201510231636365317.ppt', '0 软件测试：课程总体介绍.ppt', '1', 'roy_course', '4014592');
INSERT INTO `roy_attachment` VALUES ('21', '0', 'G:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/royxu/attachment/course_201510231636361296.ppt', 'application/vnd.ms-powerpoint', 'course_201510231636361296.ppt', '1 软件测试：引论.ppt', '1', 'roy_course', '1707520');

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
  PRIMARY KEY (`award_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_award
-- ----------------------------
INSERT INTO `roy_award` VALUES ('1', '2002-09-21', '先进党员', '校级', '南京晓庄学院');
INSERT INTO `roy_award` VALUES ('2', '2009-12-23', '先进教师', '校级', '南京晓庄学院');

-- ----------------------------
-- Table structure for `roy_basic_info`
-- ----------------------------
DROP TABLE IF EXISTS `roy_basic_info`;
CREATE TABLE `roy_basic_info` (
  `increment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
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
  PRIMARY KEY (`increment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_basic_info
-- ----------------------------
INSERT INTO `roy_basic_info` VALUES ('2', '本科', '南京晓庄学院方山校区 鹤琴楼 309室', '1972-01-01', '详细介绍<br>', 'xujiaxi@126.com', 'English Introduction<br>', '男', '徐家喜', '高级工程师', '中文简介<br>');

-- ----------------------------
-- Table structure for `roy_course`
-- ----------------------------
DROP TABLE IF EXISTS `roy_course`;
CREATE TABLE `roy_course` (
  `course_id` varchar(11) NOT NULL COMMENT '课程主键id',
  `course_grades` varchar(1024) DEFAULT NULL COMMENT '授课年级',
  `course_length` varchar(30) DEFAULT NULL COMMENT '课时',
  `course_name` varchar(1024) DEFAULT NULL COMMENT '课程名称',
  `course_intro` longtext COMMENT '课程介绍',
  `course_outline` longtext COMMENT '课程大纲',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_course
-- ----------------------------
INSERT INTO `roy_course` VALUES ('1', '2012级', '56', '单片机', '', '');
INSERT INTO `roy_course` VALUES ('2', '2010级', '54', '计算机网络', null, null);

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
  PRIMARY KEY (`experience_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_experience
-- ----------------------------
INSERT INTO `roy_experience` VALUES ('1', '南京晓庄学院担任教师', '教师', '-', '2000-09');
INSERT INTO `roy_experience` VALUES ('2', 'xxxxx大学就读', '大学生', '1994-06', '1990-09');

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
  PRIMARY KEY (`homework_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_homework
-- ----------------------------
INSERT INTO `roy_homework` VALUES ('201510051605408191', '2015-10-05 16:06:24', '0', '2015-10-06 00:18:14', '作业', '<p>作业要求1：2015年10月5日16:00:00前完成并上交；</p><p>作业要求2：保质保量完成。<br></p>');

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
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_paper
-- ----------------------------
INSERT INTO `roy_paper` VALUES ('201510021020311234', '梁轰,王江平,徐家喜', '电脑知识与技术', '摘要', '2015-06', '江苏省大学生创新项目', '基于Android的校园网站客户端的设计与实现');
INSERT INTO `roy_paper` VALUES ('201510030220124312', '梁轰,徐家喜,王江平', '南京晓庄学院学报', '摘要', '2014-12', '江苏省大学生创新项目', '公钥证书在Android APP访问校园网中的应用');
INSERT INTO `roy_paper` VALUES ('201510072130386174', '侯青, 徐家喜, 吉力', '电脑知识与技术', '针对传统海量数据存储和处理方法成本高、效率低、编写程序困难等缺点,该文搭建了基于Hadoop框架的云平台,设计和实现了基于Hadoop的校园教育资源管理系统。测试及实验结果表明,基于Hadoop的云平台在大数据和多用户并发访问环境下,系统运行稳定,数据处理快,能有效降低成本,较传统单机服务器具有明显优势,能够很好的在校园资源管理系统中得到应用。 更多还原', '2014-01', '南京晓庄学院科学研究项目', '基于Hadoop的校园教育资源管理系统');
INSERT INTO `roy_paper` VALUES ('201510072132318958', '王江平,徐家喜', '南京晓庄学院学报', '详细介绍了无线传感器网络的特点、面临的各种安全威协和安全目标.分析了目前已提出的无线传感器网络安全体系结构,并对它们的特性进行了比较.最后总结和讨论了无线传感器网络安全体系结构的研究方向. 更多还原', '2010-06', '南京晓庄学院培育项目(2010KYPY02)', '无线传感器网络安全体系结构分析');
INSERT INTO `roy_paper` VALUES ('201510072133403817', '徐家喜', '南京晓庄学院学报', '介绍了基于C8051F350单片机电阻测量系统的实现方法.重点给出了电阻测量系统的硬件和软件设计过程.该系统用C8051F350作为其核心,具有数据存储、与PC通信以及LCD显示等功能.使用结果表明,该系统软硬件设计完善,可靠性高,系统功耗低、精度高、使用方便. 更多还原', '2012-06', '无', '基于单片机C8051F350电阻测量系统的设计与实现');
INSERT INTO `roy_paper` VALUES ('201510072134279979', '徐家喜', '南京晓庄学院学报', '设计了一套基于Web的开放性实验管理系统,分析了系统的架构及主要功能模块,并对系统关键功能模块如:权限管理、word文档输出、实验日志管理、数据备份等实现作了详细介绍.系统运行结果表明,该设计提高了开放性实验管理的效率,方便了师生. 更多还原.', '2010-06', '南京晓庄学院院级教改项目(2009JYKT018)', '开放性实验管理系统的设计与实现');
INSERT INTO `roy_paper` VALUES ('201510072135207102', '王江平,徐家喜', '南京晓庄学院学报', '该文介绍光学脉冲磁场传感器的特点及实用化进程中存在的问题,理论分析了尺度因子对光学传感器测量精度的影响.通过对传统的尺度因子的计算算法进行改进,导出一般情况下尺度因子的理论表达式;提出提高光学脉冲磁场传感器尺度因子的方法:通过合理设置偏振角可以改变尺度因子进而提高光学脉冲磁场传感器的性能;实验测量出尺度因子的值,结果表明尺度因子理论值和实验测试数据可以保持一致. 更多还原', '2012-03', '国家自然科学基金(60472007)资助项目;南京晓庄学院培育项目(2010KYPY02)', '尺度因子对光学脉冲磁场传感器性能的影响');
INSERT INTO `roy_paper` VALUES ('201510072136139218', '徐家喜', '南京晓庄学院学报', '教学质量高低是教学活动的成效性外在表现形式 ,而良好的教学评价对教学质量有导向、促进、激励及调控功能。对教学活动的评价分析时常常遇到大量烦琐的数据计算 ,如 :标准分Z、标准差S、高分率等 ,而且查询修改起来十分不方便。为此 ,我们根据教学的具体情况和需求 ,建立了一套基于WIN/98/NT的教学评价管理系统 ,来管理数据资料、客观分析评估教学效果', '2000-04', '无', 'DELPHI语言在教学评价管理系统中的应用');

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
  PRIMARY KEY (`proj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_science_project
-- ----------------------------
INSERT INTO `roy_science_project` VALUES ('201510051554129617', '2015-10', '主持', '10万', '项目旨在设计开发一款实用性强，效率高的信息管理平台，提高工作效率，加强管理。', '科研项目1', '江苏省教育厅', '2014-10');
INSERT INTO `roy_science_project` VALUES ('201510072225250144', '2015-12', '主持', '5万', '开发基于SpringMVC+Hibernate+EasyUI的企业管理系统。', '科研项目2', '南京晓庄学院信息工程学院', '2014-09');
INSERT INTO `roy_science_project` VALUES ('201510072226357804', '2016-03', '主持', '20万', '开发基于SpringMVC+Hibernate+Bootstrap+Birt的动态报表管理系统。', '科研项目3', '南京晓庄学院', '2013-09');

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
  PRIMARY KEY (`stu_proj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roy_student_project
-- ----------------------------
INSERT INTO `roy_student_project` VALUES ('201510051554378350', '季啸,何映蝶', '梁轰,袁春雷,黄会,黄天翔', '1、完成应用开发。\r\n2、申请相关软件著作权。\r\n3、发表1-2篇专业相关论文。', '基于Android的校园信息化平台设计与实现', '省级', '江苏省大学生创新项目', '王江平,徐家喜');
INSERT INTO `roy_student_project` VALUES ('201510072228082029', '梁轰', '无', '1、完成基于SpringMVC+EasyUI+Hibernate的权限管理系统的开发。\r\n2、撰写项目相关的专业论文。', '基于SpringMVC+EasyUI+Hibernate的权限管理系统', '校级', '指导项目', '徐家喜');
INSERT INTO `roy_student_project` VALUES ('201510072239324712', '梁轰', '无', '完成基于SpringMVC+Hibernate+Bootstrap的个人信息管理系统的平台开发。', '基于SpringMVC+Hibernate+Bootstrap的个人信息管理系统', '个人指导', '个人项目', '徐家喜');

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
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

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
INSERT INTO `sys_menu` VALUES ('0', '超级管理员', '', '0', null, '#', '', '0', '商城管理系统', '根菜单', '1.1', '', '');
INSERT INTO `sys_menu` VALUES ('1', '超级管理员', '', '0', '0', '#', '', '1', '系统功能', '', '10.1', '', '');
INSERT INTO `sys_menu` VALUES ('101', '超级管理员', '', '0', '1', '/jsp/menu/menu.jsp', '', '2', '菜单管理', '', '20.2', '管理员', '2015-06-01 13:26:16');
INSERT INTO `sys_menu` VALUES ('102', '管理员', '2015-06-01 13:04:07', '0', '1', '/jsp/role/role.jsp', '', '2', '角色菜单管理', '', '20.3', '管理员', '2015-06-01 13:45:56');
INSERT INTO `sys_menu` VALUES ('103', '管理员', '2015-06-01 13:12:55', '0', '1', '/jsp/user/user.jsp', '', '2', '用户管理', '', '20.1', '管理员', '2015-06-01 13:26:26');
INSERT INTO `sys_menu` VALUES ('104', '管理员', '2015-06-01 13:28:36', '0', '1', '/jsp/userrole/userrole.jsp', '', '2', '用户角色分配', '', '20.4', '管理员', '2015-06-01 13:29:00');
INSERT INTO `sys_menu` VALUES ('105', '管理员', '2015-06-02 15:55:50', '0', '1', '/jsp/codegenerate/codegenerate.jsp', '', '2', '代码生成器', '', '20.5', '管理员', '2015-06-02 15:55:50');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '2015-06-01 17:00:38', '0,1,103,101,102,104,105', '超级管理员', '超级管理员', '超级管理员', '2015-10-08 16:57:37');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', 'null', '0', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '0', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '101', '1');
INSERT INTO `sys_role_menu` VALUES ('4', '1', '102', '1');
INSERT INTO `sys_role_menu` VALUES ('5', '1', '103', '1');
INSERT INTO `sys_role_menu` VALUES ('6', '1', '104', '1');
INSERT INTO `sys_role_menu` VALUES ('7', '1', '105', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, null, null, '0', null, null, null, null, null, 'admin', null, null, null, null, null, null, null, '超级管理员', null, 'admin');
INSERT INTO `sys_user` VALUES ('2', null, null, null, '0', null, null, null, null, null, 'user2', null, null, null, null, null, null, null, '用户2', null, '123456');
INSERT INTO `sys_user` VALUES ('3', null, null, null, '0', null, null, null, null, null, 'user3', null, null, null, null, null, null, null, '用户3', null, '123456');
INSERT INTO `sys_user` VALUES ('5', null, '超级管理员', '2015-09-29 22:43:14', '0', null, null, null, null, null, 'user4', null, null, null, null, null, null, null, 'user4', null, '123456');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', 'admin');

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
