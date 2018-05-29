
document.write('\
<div><div><div style="display:none;"><ul id="imenus0" style="width:525px">\
<li  style="width:135px;"><a href="#" target="_new">Who We Are</a>\
\
	<div><div style="width:135px;top:0px;left:0px;"><ul style="">\
	<li ><a href="sample_link.html" target="_new">Overview</a></li>\
	<li ><a href="sample_link.html" target="_new">Mission & Goals</a></li>\
	<li ><a href="sample_link.html" target="_new">History</a></li>\
	<li ><a href="sample_link.html" target="_new">Management</a></li>\
	<li ><a href="sample_link.html" target="_new">Work Center</a></li>\
	<li ><a href="sample_link.html" target="_new">Press Center</a></li>\
	<li ><a href="#" target="_new">Worldwide</a>\
\
		<div><div style="width:140px;top:-19px;left:123px;"><ul style="">\
		<li ><a href="sample_link.html" target="_new">Europe</a></li>\
		<li ><a href="sample_link.html" target="_new">Asia</a></li>\
		<li ><a href="sample_link.html" target="_new">US & Canada</a></li>\
		<li ><a href="sample_link.html" target="_new">Mexico</a></li>\
		<li ><a href="sample_link.html" target="_new">Australia</a></li>\
		<li ><a href="sample_link.html" target="_new">Middle East</a></li>\
		</ul></div></div></li>\
\
	<li ><a href="#" target="_new">Directors</a>\
\
		<div><div style="width:140px;top:-18px;left:123px;"><ul style="">\
		<li ><a href="sample_link.html" target="_new">Overview</a></li>\
		<li ><a href="sample_link.html" target="_new">Electronics</a></li>\
		<li ><a href="sample_link.html" target="_new">Fire & Security</a></li>\
		<li ><a href="sample_link.html" target="_new">Healthcare</a></li>\
		<li ><a href="sample_link.html" target="_new">Plastics & Adhesives</a></li>\
		<li ><a href="sample_link.html" target="_new">Engineered Producs</a></li>\
		<li ><a href="sample_link.html" target="_new">Tyco Worldwide</a></li>\
		</ul></div></div></li>\
\
	<li ><a href="#" target="_new">Worldwide</a>\
\
		<div><div style="width:140px;top:-18px;left:123px;"><ul style="">\
		<li ><a href="sample_link.html" target="_new">Europe</a></li>\
		<li ><a href="sample_link.html" target="_new">Asia</a></li>\
		<li ><a href="sample_link.html" target="_new">US & Canada</a></li>\
		<li ><a href="sample_link.html" target="_new">Mexico</a></li>\
		<li ><a href="sample_link.html" target="_new">Australia</a></li>\
		<li ><a href="sample_link.html" target="_new">Middle East</a></li>\
		</ul></div></div></li>\
\
	<li ><a href="#" target="_new">Customers</a></li>\
	</ul></div></div></li>\
\
<li  style="width:140px;"><a href="#" target="_new">Our Commitment</a>\
\
	<div><div style="width:140px;top:;left:;"><ul style="">\
	<li ><a href="sample_link.html" target="_new">Overview</a></li>\
	<li ><a href="sample_link.html" target="_new">People & Values</a></li>\
	<li ><a href="sample_link.html" target="_new">Governance</a></li>\
	<li ><a href="sample_link.html" target="_new">Community</a></li>\
	<li ><a href="sample_link.html" target="_new">Environmental</a></li>\
	</ul></div></div></li>\
\
<li  style="width:125px;"><a href="#" target="_new">Our Business</a>\
\
	<div><div style="width:125px;top:;left:;"><ul style="">\
	<li ><a href="sample_link.html" target="_new">Overview</a></li>\
	<li ><a href="sample_link.html" target="_new">Electronics</a></li>\
	<li ><a href="sample_link.html" target="_new">Fire & Security</a></li>\
	<li ><a href="sample_link.html" target="_new">Healthcare</a></li>\
	<li ><a href="sample_link.html" target="_new">Plastics & Adhesives</a></li>\
	<li ><a href="sample_link.html" target="_new">Engineered Producs</a></li>\
	<li ><a href="sample_link.html" target="_new">Tyco Worldwide</a></li>\
	</ul></div></div></li>\
\
<li  style="width:125px;"><a href="#" target="_new">Investors</a>\
\
	<div><div style="width:126px;top:;left:;"><ul style="">\
	<li ><a href="sample_link.html" target="_new">Overview</a></li>\
	<li ><a href="sample_link.html" target="_new">Stock Quotes</a></li>\
	</ul></div></div></li>\
\
</ul><div style="clear:left;"></div></div></div></div>\
');







/*

          Tips & Tricks

             1: Adjust the "function menudata0()" numeric id in the statement below to match the numeric id of
                the id='imenus0' statement within the menu structure and links secion above.  The numbers must 
                match for the menu to work, multiple menus may be used on a single page by adding new sections 
                with new id's.

             2: To specifically define settings for an individual item or container, apply classes or inline styles
                directly to the UL and A tags in the HTML tags which define your menus structure and links above.

             3: Use the parameter options below to define borders and padding.  Borders and padding specified
                within the menus HTML structure may cause positioning and actual sizing to be offset a bit in
                some browsers.
 
*/




/*-------------------------------------------------
************* Parameter Settings ******************
---------------------------------------------------*/


function imenus_data0(){


	this.enable_visual_design_mode = true			//turns the visual design pad option on or off

	this.main_is_horizontal = true
	this.menu_showhide_delay = 150


   /*---------------------------------------------
   Expand Icon Images
   ---------------------------------------------*/

	this.main_expand_image = "arrow_main.gif"
	this.main_expand_image_hover = "arrow_main.gif"
	this.main_expand_image_width = "7"
	this.main_expand_image_height = "5"
	this.main_expand_image_offx = "-1"
	this.main_expand_image_offy = "5"

	this.sub_expand_image = "arrow_sub.gif"
	this.sub_expand_image_hover = "arrow_sub.gif"
	this.sub_expand_image_width = "10"
	this.sub_expand_image_height = "13"
	this.sub_expand_image_offx = "0"
	this.sub_expand_image_offy = "0"



   /*---------------------------------------------
   Global Menu Styles
   ---------------------------------------------*/

	//Main Menu

	this.main_container_styles = "background-color:#06437d; border-style:solid; border-color:#769bba; border-width:1px; padding-top:0px; padding-right:0px; padding-bottom:0px; padding-left:0px; "
	this.main_item_styles = "color:#e6e6e6; text-align:center; font-family:Arial; font-size:12px; font-weight:bold; text-decoration:none; padding-top:4px; padding-right:5px; padding-bottom:4px; padding-left:12px; border-style:none; border-color:#000000; border-width:0px; "
	this.main_item_hover_styles = "background-color:#cce3f8; color:#111111; "
	this.main_item_active_styles = "text-decoration:underline; "


	//Sub Menu

	this.subs_container_styles = "background-color:#cce3f8; border-style:solid; border-color:#356595; border-width:1px; padding-top:5px; padding-right:5px; padding-bottom:5px; padding-left:5px; "
	this.subs_item_styles = "color:#111111; text-align:left; font-size:11px; font-weight:normal; text-decoration:none; padding-top:2px; padding-right:5px; padding-bottom:2px; padding-left:5px; border-style:none; border-width:1px; "
	this.subs_item_hover_styles = "background-color:#ffffff; "
	this.subs_item_active_styles = "text-decoration:underline; "


}


