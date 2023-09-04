
package api.swagger.dataprovider;

import org.testng.annotations.DataProvider;

import api.swagger.utilities.ExcelUtility;


public class DataProviders {
	static String excle_path = "src/test/resources/TestData.xlsx";

	// Create User
	@DataProvider(name = "CreateUser_Data")
	public Object[][] CreateUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path,"CreateUser");
	}
	// Get User
	@DataProvider(name = "GetUser_Data")
	public Object[][]GetUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path,"GetUser");
	}
	// Update User
	@DataProvider(name = "UpdateUser_Data")
	public Object[][]UpdateUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path,"UpdateUser");
	}
	// Login User
	@DataProvider(name = "LoginUser_Data")
	public Object[][]LoginUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path,"LoginUser");
	}
	// Delete User
	@DataProvider(name = "DeleteUser_Data")
	public Object[][]DeleteUserTestData() {
		return ExcelUtility.excelIntoArray(excle_path,"DeleteUser");
	}
}
