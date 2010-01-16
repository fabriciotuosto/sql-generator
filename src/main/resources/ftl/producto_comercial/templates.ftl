<#-- Asociacion de producto comercial con templates -->
<#assign subquery_prod_com = "SELECT P_ID FROM T_CONFIG_PROD_COM_PAPEL_CLASIF WHERE f_producto_comercial IN (SELECT p_id FROM t_producto_com_papel_clas WHERE p_id in (SELECT p_id FROM T_PROD_COMERCIAL WHERE upper(a_nombre) = upper('${row.getColumn('G')}')) AND f_producto_tecnico = (${subquery_producto_tecnico}) AND f_tipo_operacion = (${subquery_tipo_operacion}) AND f_nivel_estr_papel_clasif = (${subquery_nivel_est}))">
<#list util.getTokens(row.getColumn('R'),';') as token>
	<#if token == 'sin template'>
		INSERT INTO T_CONF_PROD_COM_TEMPLATE_DETAL (F_CONFIG_PROD_COMERCIAL, F_TEMPLATE_DETALLADO) VALUES ( (${subquery_prod_com}) , (SELECT P_ID FROM T_TEMPLATE_DETALLADO WHERE A_NOMBRE = '${token}') )
	</#if>
</#list>