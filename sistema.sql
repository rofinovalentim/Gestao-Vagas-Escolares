/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : sistema

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-11-29 08:15:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `distrito`
-- ----------------------------
DROP TABLE IF EXISTS `distrito`;
CREATE TABLE `distrito` (
`idDistrito`  int(11) NOT NULL AUTO_INCREMENT ,
`nomeDestrito`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`provincia`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`idDistrito`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=33

;

-- ----------------------------
-- Records of distrito
-- ----------------------------
BEGIN;
INSERT INTO `distrito` VALUES ('1', 'pemba', 'Cabo Delgado'), ('2', 'macomia', 'Cabo Delgado'), ('3', 'mecufi', 'Cabo Delgado'), ('4', 'morebue', 'Cabo Delgado'), ('29', 'ggg', 'Cabo Delgado'), ('30', 'rrrr', 'Cabo Delgado'), ('31', 'ExAME', 'Cabo Delgado'), ('32', 'eXEMPLO', 'Cabo Delgado');
COMMIT;

-- ----------------------------
-- Table structure for `escola`
-- ----------------------------
DROP TABLE IF EXISTS `escola`;
CREATE TABLE `escola` (
`idEscola`  int(11) NOT NULL AUTO_INCREMENT ,
`nomeEscola`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`iddistrito`  int(255) NULL DEFAULT NULL ,
`endereco`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`telefone`  int(20) NULL DEFAULT NULL ,
`email`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`idEscola`),
FOREIGN KEY (`iddistrito`) REFERENCES `distrito` (`idDistrito`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `iddistrito` (`iddistrito`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=25

;

-- ----------------------------
-- Records of escola
-- ----------------------------
BEGIN;
INSERT INTO `escola` VALUES ('11', 'escola secundaria dom bosco', '1', 'rua 14', '655444', 'dombosco@gmail.com'), ('14', '25 de setembro', '1', 'rua 15', '8544444', 'rr@unilurio.ac.mz'), ('15', 'Escola Secundaria SOS', '1', 'av. marginal', '45544', 'rvalentim@unilurio.ac.mz'), ('24', 'Roff', '3', '1', '23222', 'chunga@gmail.com');
COMMIT;

-- ----------------------------
-- Table structure for `estudante`
-- ----------------------------
DROP TABLE IF EXISTS `estudante`;
CREATE TABLE `estudante` (
`idEstudante`  int(11) NOT NULL AUTO_INCREMENT ,
`nomeEstudante`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`dataNascimento`  date NULL DEFAULT NULL ,
`email`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`nrBI`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`telefone`  int(20) NULL DEFAULT NULL ,
`idGenero`  int(11) NULL DEFAULT NULL ,
`idEscola`  int(11) NULL DEFAULT NULL ,
`classe`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`idEstudante`),
FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`idEscola`, `classe`) REFERENCES `vagas` (`idEscola`, `classe`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `idGenero` (`idGenero`) USING BTREE ,
INDEX `idEscola` (`idEscola`, `classe`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=57

;

-- ----------------------------
-- Records of estudante
-- ----------------------------
BEGIN;
INSERT INTO `estudante` VALUES ('50', 'Ussimane Muieva', '2018-11-06', 'ussimane.maria@unilurio.ac.mz', '12233v', '8584848', '1', '11', '9classe'), ('51', 'Rofino Simao Domingos', '2018-11-14', 'dombosco@gmail.com', '12233v', '8584848', '1', '11', '9classe'), ('52', 'barata', '1999-12-12', 'bbarata@unilurio.ac.mz', '12233v', '8584848', '1', '14', '9classe'), ('56', 'teste', '2018-11-06', 'rvalentim@unilurio.ac.mz', 'bbb', '57557', '1', '11', '9classe');
COMMIT;

-- ----------------------------
-- Table structure for `estudanteaceite`
-- ----------------------------
DROP TABLE IF EXISTS `estudanteaceite`;
CREATE TABLE `estudanteaceite` (
`idEstudante`  int(11) NOT NULL ,
`nomeEstudante`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`dataNascimento`  date NULL DEFAULT NULL ,
`email`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`telefone`  decimal(10,0) NULL DEFAULT NULL ,
`nrBI`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`genero`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`escola`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`classe`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`idEstudante`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of estudanteaceite
-- ----------------------------
BEGIN;
INSERT INTO `estudanteaceite` VALUES ('48', 'Tarcila Festo', '2018-11-08', 'dombosco@gmail.com', '8584848', null, 'Femenino', 'Escola Secundaria SOS', '12classe'), ('49', 'admin', '2018-11-02', 'rvalentim@unilurio.ac.mz', '87837575', null, 'Femenino', 'escola secundaria dom bosco', '9classe');
COMMIT;

-- ----------------------------
-- Table structure for `genero`
-- ----------------------------
DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
`idGenero`  int(11) NOT NULL ,
`descricao`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`idGenero`),
INDEX `idGenero` (`idGenero`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of genero
-- ----------------------------
BEGIN;
INSERT INTO `genero` VALUES ('1', 'Masculino'), ('2', 'Femenino');
COMMIT;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
`role`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`recurso`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`role`),
INDEX `role` (`role`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('', null), ('AceitarInscricao', '/AceitarInscricao'), ('AdicionarDistrito', '/adicionarDistrito.jsp'), ('AdicionarUsuario', '/cadastrarAdministrador.jsp'), ('AlterarSenha', '/alterarSenha.jsp'), ('CadastrarEscola', '/cadastrarEscola.jsp'), ('EditarEscola', '/EditarEscola'), ('EditarUsuario', '/EditarUsuario'), ('EliminarEscola', '/EliminarEscola.jsp'), ('EliminarUsuario', '/EliminarUsuario'), ('PaginaPrincipal', '/index.jsp'), ('Veraceites', '/aceites.jsp'), ('VerEscolas', '/listaEscola.jsp'), ('VerEstudantes', '/listaEstudantes.jsp'), ('VerUsuarios', '/listaUsuario.jsp');
COMMIT;

-- ----------------------------
-- Table structure for `tipo_usuario`
-- ----------------------------
DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE `tipo_usuario` (
`idTipo`  int(11) NOT NULL AUTO_INCREMENT ,
`descricao`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
PRIMARY KEY (`idTipo`),
INDEX `idTipo` (`idTipo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of tipo_usuario
-- ----------------------------
BEGIN;
INSERT INTO `tipo_usuario` VALUES ('1', 'SuperAdministrador'), ('2', 'Administrador'), ('3', 'Convidado');
COMMIT;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`userName`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`password`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`email`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL ,
`idTipo`  int(255) NULL DEFAULT NULL ,
PRIMARY KEY (`userName`),
FOREIGN KEY (`idTipo`) REFERENCES `tipo_usuario` (`idTipo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `user_ibfk_1` (`idTipo`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('barata', 'barata', 'rvalentim@unilurio.ac.mz', '1'), ('biemos', 'biemos', 'bbiemos@unilurio.ac.mz', '2'), ('dalton', 'rvalentim', 'rvalentim@unilurio.ac.mz', '2'), ('gimo', 'gimo', 'egimo@unilurio.ac.mz', '2'), ('joana', 'rvalentim', 'rvalentim@unilurio.ac.mz', '2'), ('maria', 'rvalentim', 'rvalentim@unilurio.ac.mz', '2'), ('meneses', 'meneses', 'ameneses@unilurio.ac.mz', '2'), ('nnn', 'rvalentim', 'rvalentim@unilurio.ac.mz', '2'), ('raimundo', 'raimundo', 'raimundo.jose@unilurio.ac.mz', '2'), ('raufo', 'raufo', 'rnhamposse@unilurio.ac.mz', '1'), ('rvalentim', 'rvalentim', 'rvalentim@unilurio.ac.mz', '1'), ('rvavvvvvvvvvvvvvvvvvvv', 'rvalentim', 'rvalentim@unilurio.ac.mz', '2'), ('Tamires', 'tamires', 'tlourei@unilurio.ac.mz', '2'), ('teste', 'gimo', 'egimo@unilurio.ac.mz', '2');
COMMIT;

-- ----------------------------
-- Table structure for `usuario_previlegio`
-- ----------------------------
DROP TABLE IF EXISTS `usuario_previlegio`;
CREATE TABLE `usuario_previlegio` (
`Tipouser`  int(255) NOT NULL ,
`previlegio`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
PRIMARY KEY (`previlegio`, `Tipouser`),
FOREIGN KEY (`Tipouser`) REFERENCES `tipo_usuario` (`idTipo`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`previlegio`) REFERENCES `role` (`role`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `previlegio` (`previlegio`) USING BTREE ,
INDEX `usuario_previlegio_ibfk_1` (`Tipouser`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of usuario_previlegio
-- ----------------------------
BEGIN;
INSERT INTO `usuario_previlegio` VALUES ('1', 'AdicionarDistrito'), ('2', 'AdicionarDistrito'), ('1', 'AdicionarUsuario'), ('1', 'AlterarSenha'), ('2', 'AlterarSenha'), ('1', 'CadastrarEscola'), ('2', 'CadastrarEscola'), ('1', 'EditarUsuario'), ('1', 'EliminarUsuario'), ('1', 'PaginaPrincipal'), ('2', 'PaginaPrincipal'), ('3', 'PaginaPrincipal'), ('1', 'Veraceites'), ('2', 'Veraceites'), ('1', 'VerEscolas'), ('2', 'VerEscolas'), ('1', 'VerEstudantes'), ('2', 'VerEstudantes'), ('1', 'VerUsuarios');
COMMIT;

-- ----------------------------
-- Table structure for `vagas`
-- ----------------------------
DROP TABLE IF EXISTS `vagas`;
CREATE TABLE `vagas` (
`idEscola`  int(11) NOT NULL ,
`classe`  varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL ,
`nrVagas`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`idEscola`, `classe`),
FOREIGN KEY (`idEscola`) REFERENCES `escola` (`idEscola`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of vagas
-- ----------------------------
BEGIN;
INSERT INTO `vagas` VALUES ('11', '10classe', '0'), ('11', '11classe', '1'), ('11', '12classe', '0'), ('11', '8classe', '0'), ('11', '9classe', '1'), ('14', '10classe', '9'), ('14', '11classe', '11'), ('14', '12classe', '11'), ('14', '8classe', '7'), ('14', '9classe', '1'), ('15', '10classe', '9'), ('15', '11classe', '0'), ('15', '12classe', '11'), ('15', '8classe', '0'), ('15', '9classe', '9'), ('24', '10classe', '1'), ('24', '11classe', '1'), ('24', '12classe', '1'), ('24', '8classe', '1'), ('24', '9classe', '0');
COMMIT;

-- ----------------------------
-- Auto increment value for `distrito`
-- ----------------------------
ALTER TABLE `distrito` AUTO_INCREMENT=33;

-- ----------------------------
-- Auto increment value for `escola`
-- ----------------------------
ALTER TABLE `escola` AUTO_INCREMENT=25;

-- ----------------------------
-- Auto increment value for `estudante`
-- ----------------------------
ALTER TABLE `estudante` AUTO_INCREMENT=57;

-- ----------------------------
-- Auto increment value for `tipo_usuario`
-- ----------------------------
ALTER TABLE `tipo_usuario` AUTO_INCREMENT=4;
