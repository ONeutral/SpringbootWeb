
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_article_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_comment`;
CREATE TABLE `blog_article_comment`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(40) NOT NULL,
  `comment_name` varchar(10) CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL,
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `is_delete` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除，默认为0，1为是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_article_comment
-- ---------------------------
-- ----------------------------
-- Table structure for blog_article_content
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_content`;
CREATE TABLE `blog_article_content`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_content` text CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL COMMENT '文章内容',
  `article_id` bigint(40) NOT NULL COMMENT '文章id,对应info的id',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_article_content
-- ----------------------------
-- ----------------------------
-- Table structure for blog_article_image
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_image`;
CREATE TABLE `blog_article_image`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(40) NOT NULL COMMENT '对应文章id',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '图片url',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '这张表用来保存题图url，每一篇文章都应该有题图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_article_image
-- ----------------------------
-- ----------------------------
-- Table structure for blog_article_info
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_info`;
CREATE TABLE `blog_article_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(20) CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `article_title` varchar(255) CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL COMMENT '文章标题',
  `article_views` int(10) NOT NULL DEFAULT 0 COMMENT '访问量',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除，默认为0，1为是',
  `like_num` int(10) NOT NULL DEFAULT 0 COMMENT '点赞数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_title`(`article_title`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_article_info
-- ----------------------------
-- ----------------------------
-- Table structure for blog_article_replay
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_replay`;
CREATE TABLE `blog_article_replay`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(40) NOT NULL,
  `replay` varchar(255) CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL,
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `is_delete` int(10) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_article_replay
-- ----------------------------
-- ----------------------------
-- Table structure for blog_blog_num
-- ----------------------------
DROP TABLE IF EXISTS `blog_blog_num`;
CREATE TABLE `blog_blog_num`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `views` int(10) NOT NULL COMMENT '每日的访问量',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 335 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_blog_num
-- ----------------------------
-- ----------------------------
-- Table structure for blog_historical_views
-- ----------------------------
DROP TABLE IF EXISTS `blog_historical_views`;
CREATE TABLE `blog_historical_views`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `views` int(10) NOT NULL COMMENT '每日的访问量',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 335 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_historical_views
-- ----------------------------
-- ----------------------------
-- Table structure for blog_info_sort
-- ----------------------------
DROP TABLE IF EXISTS `blog_info_sort`;
CREATE TABLE `blog_info_sort`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `sort_id` bigint(40) NOT NULL COMMENT '分类id',
  `article_id` bigint(40) NOT NULL COMMENT '文章id',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_info_sort
-- ----------------------------

-- ----------------------------
-- Table structure for blog_like_num
-- ----------------------------
DROP TABLE IF EXISTS `blog_like_num`;
CREATE TABLE `blog_like_num`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `views` int(10) NOT NULL COMMENT '每日的访问量',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 259 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_like_num
-- ----------------------------


-- ----------------------------
-- Table structure for blog_sort
-- ----------------------------
DROP TABLE IF EXISTS `blog_sort`;
CREATE TABLE `blog_sort`  (
  `id` bigint(40) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(20) CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `sort_number` tinyint(10) NOT NULL DEFAULT 0 COMMENT '数量',
  `create_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_by` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_effective` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效，默认1有效，0无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_sort
-- ----------------------------

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `login_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `login_role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '是否激活，默认为0',
  `create_by` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_user
-- ----------------------------

-- ----------------------------
-- Table structure for blog_user_like
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_like`;
CREATE TABLE `blog_user_like`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `article_id` bigint(20) NOT NULL COMMENT '被点赞的文章id',
  `like_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '用户是否点赞，默认为0，0未点赞，1点赞',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_user_like
-- ----------------------------

-- ----------------------------
-- Table structure for blog_user_view
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_view`;
CREATE TABLE `blog_user_view`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(255) CHARACTER SET utf8  COLLATE utf8_general_ci NOT NULL,
  `view` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8  COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_user_view
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
