package com.starquik.pageObject;

public class QuotationPageObject {
	
	public static String QuotationPageText_Xpath = "//li[contains(text(), 'Quotations')]";
	public static String createButton_Xpath = "//button[contains(text(), 'Create')]";
	public static String newText_Xpath = "//span[contains(text(), 'New')]";
	public static String customerNameText_xpath="//*[@id='o_field_input_6']";
	public static String deliveryDatefield_xpath= "//input[@name='delivery_slot_date']";
	public static String addItem_LinkText= "Add an item";
	public static String itemInput_Xpath= "/html/body/div[1]/div/div[2]/div/div/div[1]/div/div[5]/div/div[1]/div[1]/div[2]/div[1]/div[1]/div/input";
	public static String otherInfoTab_Xpath = "//a[contains(text(), 'Other Information')]";
	public static String orderLineTab_Xpath = "//a[contains(text(), 'Order Lines')]";
	public static String okButtonDialogue_Css= ".modal-footer > button:nth-child(1)";
	public static String saleOrderWeight_Xpath = "//label[contains(text(), 'Sale Order Weight')]";
	public static String warehouseTextfield_Xpath= "#o_field_input_60";
	public static String activateDeliveryCheckbox_Name = "activate_delivery";
	public static String customerRefnoTextField_Xpath = "//input[starts-with(@id,'o_field_input_71')]";
	public static String deliverySlot_Id = "o_field_input_21";
	public static String SaveButton_Css = ".o_form_button_save";
	
}
