<%@ page language="java" import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <body leftmargin='15' topmargin='15' marginleft='15' marginleft='15' bgcolor='#ffffff'>
        <div style="color:#000000; font-size:13px; font-family:Arial; font-weight:bold;">
            <img src="/POUSADA/main/menu/images/parajuru.jpg" width="752" height="124">
        </div>
        <table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" height="1">
            <tr>
                <td style="color:#111111; font-size:10px; text-decoration:none; font-family:Arial;" align="right">                
                Voc� � o visitante n�mero <font color="#FF0000"><b><%=application.getAttribute("numVisitas")%></b></font> 
                </td>
            </tr>
        </table>
        <div style="padding:30px;padding-bottom:300px;">

            <!--||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

            Infinite Menus - Structure and Links

            Note: All required source code and setting are in this file.

            ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||-->
            <div style="color:#000000; font-size:13px; font-family:Arial; font-weight:bold;">Pousada Tabajara - Parajuru</div>




            <div>
                <div>
                    <div style="display:none;">
                        <ul id="imenus0" style="width:580px">
                            <li  style="width:145px;">
                                <a href="#" target="_self">Cadastro</a>

                                <div>
                                    <div style="width:145px;top:4px;left:0px;">
                                        <ul style="">
                                            <li ><a href="/POUSADA/main/menu/cadastrarAp.jsp" target="_self"> - Cadastro de Apartamentos</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li  style="width:145px;">
                                <a href="#" target="_self">Opera��es</a>

                                <div>
                                    <div style="width:146px;top:4px;left:-1px;">
                                        <ul style="">
                                            <li ><a href="/POUSADA/main/menu/ocuparAp.jsp" target="_self"> - Ocupar Apartamento</a></li>
                                            <li ><a href="/POUSADA/main/menu/adicionarCamasAp.jsp" target="_self"> - Inserir Camas</a></li>
                                            <li ><a href="/POUSADA/main/menu/adicionarConsumoAp.jsp" target="_self"> - Inserir Consumo</a></li>
                                            <li ><a href="/POUSADA/main/menu/adicionarDiasAp.jsp" target="_self"> - Adicionar Dias de Ocupa��o</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li  style="width:145px;"><a href="#" target="_self">Consultas</a>

                                <div>
                                    <div style="width:146px;top:4px;left:0px;">
                                        <ul style="">
                                            <li ><a href="/POUSADA/main/menu/statusAp.jsp" target="_self"> - Status do Apartamento</a></li>
                                            <li ><a href="/POUSADA/main/menu/totalPagarAp.jsp" target="_self"> - Total a Pagar por Apartamento</a></li>
                                            <li ><a href="/POUSADA/main/menu/consumoAp.jsp" target="_self"> - Consumo do Apartamento</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li  style="width:145px;">
                                <a href="#" target="_self">Relat�rios</a>

                                <div>
                                    <div style="width:146px;top:4px;left:-1px;">
                                        <ul style="">
                                            <li ><a href="/POUSADA/main/menu/StatusApRel.jsp" target="_self"> - Apartamentos por Status</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>

                            <li  style="width:145px;">
                                <a href="#" target="_self">Sobre</a>

                                <div>
                                    <div style="width:146px;top:4px;left:-1px;">
                                        <ul style="">
                                            <li ><a href="/POUSADA/main/menu/sobre.jsp" target="_self"> - Sistema</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
	
                        </ul>
                        <div style="clear:left;">
                        </div>
                    </div>
                </div>
            </div>


            <!--||||||||||||||||||||||||||||||||End Menu Structure and Links |||||||||||||||||||||||||||||||||||||||||||-->





            <!--**********************************************************************************************************

            Infinite Menus - Parameter Settings and Source Code

            Note: Menu structure and links are defined above with UL and LI tags.

            ************************************************************************************************************-->

            <script language="JavaScript">




                /*-------------------------------------------------
                ************* Parameter Settings ******************
                ---------------------------------------------------*/


                function imenus_data0(){


                    this.enable_visual_design_mode = false

                    this.main_is_horizontal = true
                    this.menu_showhide_delay = 150


                /*---------------------------------------------
                Expand Icon Images
                ---------------------------------------------*/

                    this.main_expand_image = "http://www.opencube.com/vim/images/sample3_main_arrow.gif"
                    this.main_expand_image_hover = "http://www.opencube.com/vim/images/sample3_main_arrow.gif"
                    this.main_expand_image_width = "7"
                    this.main_expand_image_height = "5"
                    this.main_expand_image_offx = "0"
                    this.main_expand_image_offy = "5"

                    this.sub_expand_image = "http://www.opencube.com/vim/images/sample3_sub_arrow.gif"
                    this.sub_expand_image_hover = "http://www.opencube.com/vim/images/sample3_sub_arrow.gif"
                    this.sub_expand_image_width = "5"
                    this.sub_expand_image_height = "7"
                    this.sub_expand_image_offx = "0"
                    this.sub_expand_image_offy = "3"



                /*---------------------------------------------
                Global Menu Styles
                ---------------------------------------------*/

                //Main Menu

                    this.main_container_styles = "border-style:none; border-color:#6a6a6a; border-width:1px; padding-top:4px; padding-right:4px; padding-bottom:4px; padding-left:4px; "
                    this.main_item_styles = "color:#333333; text-align:left; font-family:Arial; font-size:12px; font-weight:normal; text-decoration:underline; padding-top:2px; padding-right:8px; padding-bottom:2px; padding-left:8px; border-style:solid; border-color:#dddddd; border-width:1px; "
                    this.main_item_hover_styles = "background-color:#efefef; text-decoration:underline; "
                    this.main_item_active_styles = "background-color:#efefef; "


                //Sub Menu

                    this.subs_container_styles = "background-color:#efefef; border-style:solid; border-color:#cccccc; border-width:1px; padding-top:5px; padding-right:5px; padding-bottom:5px; padding-left:5px; "
                    this.subs_item_styles = "color:#555555; text-align:left; font-size:11px; font-weight:normal; text-decoration:none; padding-top:2px; padding-right:5px; padding-bottom:2px; padding-left:5px; border-style:none; border-color:#000000; border-width:1px; "
                    this.subs_item_hover_styles = "color:#000000; text-decoration:underline; "
                    this.subs_item_active_styles = "background-color:#ffffff; "


                }

            </script>
            <!--********************************** End Parameter Settings & Code **************************************-->


            <!--Copyright Notice-->
        </div>
        <table border="0" width="100%" cellspacing="0" cellpadding="0" bgcolor="#666666" height="1">
            <tr>
                <td>
                </td>
            </tr>
        </table>
        <a href="/POUSADA/" style="text-decoration:none;">
            <div style="color:#111111; font-size:10px; text-decoration:none; font-family:Arial;">Organiza��es Tabajara Copyright, 2006. All Rights Reserved.</div>
        </a>
        <!--End Copyright Notice-->



        <!--=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=-=-=-=-=-=-=-=-

        Imenus Script File Reference

        *Note: The following script pointer should appear directly
        before your documents closing body tag.

        =-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=-=-=-=-=-=-=-=-=-=-->

        <script language="JavaScript" src="imenus.js"></script>
        
    </body>
</html>