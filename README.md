# ColorFULL-Calendar
Calendario para la agenda de eventos. Se pueden agregar, eliminar y modificar eventos conectados a una base de datos MySQL en tu localhost

-- --------------------------------------------------------

Para su uso se debe tener previamente en su máquina una Base de Datos de tipo SQL con los siguientes atributos:

-- Base de datos: `eventosbd` 
-- Estructura de tabla para la tabla `eventos`
-- 

CREATE TABLE `eventos` ( 

  `IdEvento` int(11) NOT NULL auto_increment,
  
  `fecha_inicio` date NOT NULL,
  
  `fecha_fin` date NOT NULL,
  
  `hora_inicio` int(11) NOT NULL,
  
  `min_inicio` int(11) NOT NULL,
  
  `ampm_inicio` varchar(4) NOT NULL,
  
  `hora_fin` int(11) NOT NULL,
  
  `min_fin` int(11) NOT NULL,
  
  `ampm_fin` varchar(4) NOT NULL,
  
  `titulo` varchar(50) NOT NULL,
  
  `descripcion` varchar(100) default NULL,
  
  `color_evento` varchar(20) NOT NULL,
  
  `ocurrencia` varchar(20) NOT NULL,
  
  `notificaciones` varchar(5) default NULL,
  
  PRIMARY KEY  (`IdEvento`)
  
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=80 ;
