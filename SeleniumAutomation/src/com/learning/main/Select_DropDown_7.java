package com.learning.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

public class Select_DropDown_7 {

	public static Logger LOGGER = Logger.getLogger(Select_DropDown_7.class);
	public static WebDriver DRIVER = null;
	
	public static void main(String[] args) {
		try{
			LoggerConfig.logger();
			LOGGER.error("ENTER into main - try block");
			dropDownMultipleSelection();
			dropDownSingleSelection();
			LOGGER.info("EXIT into main - try block");			
		}
		catch(Exception e){
			LOGGER.error("ENTER into main - catch block");
			LOGGER.error("Exception is " + e);
			LOGGER.error("EXIT into main - catch block");
		}
		
	}
	
	static void dropDownMultipleSelection(){
		try{
			LOGGER.info("ENTER into dropDownMultipleSelection() try block");
			String url = "http://output.jsbin.com/osebed/2";
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){
				WebElement fruitsElement = DRIVER.findElement(By.id("fruits"));
				Select fruits = new Select(fruitsElement);
				fruits.selectByIndex(1);
				fruits.selectByValue("orange");
				fruits.selectByVisibleText("Grape");
				fruits.deselectByIndex(2);
				fruits.deselectAll();
			}
			else{
				LOGGER.error("DRIVER is null");
			}
//			<select multiple="" id="fruits">
//            <option value="banana">Banana</option>
//            <option value="apple">Apple</option>
//            <option value="orange">Orange</option>
//            <option value="grape">Grape</option>
//        </select>
			LOGGER.info("EXIT from dropDownMultipleSelection() try block");
		}
		catch(Exception e){
			LOGGER.error("ENTER into dropDownMultipleSelection() catch(Exception e) block");
			LOGGER.error("Exception found is " + e);
			LOGGER.error("EXIT from dropDownMultipleSelection() catch(Exception e) block");
		}
		finally{
			DRIVER.close();
			DRIVER.quit();
		}
	}
	static void dropDownSingleSelection(){
		try{
			LOGGER.info("Enter into main() try block");
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			String url = "http://demo.guru99.com/test/newtours/register.php";
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){	
			WebElement dropDownElement = DRIVER.findElement(By.cssSelector("select[name=country]"));
			Select countryName = new Select(dropDownElement);
			countryName.selectByIndex(10);
			DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			countryName.selectByValue("BAHAMAS");
			DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			countryName.selectByVisibleText("HEARD ISLAND AND MCDONALD ISLANDS");
			// countryName.deselectAll();  // Exception is java.lang.UnsupportedOperationException: You may only deselect all options of a multi-select
			LOGGER.info("Exit from main() try block");
			}
			else{
				LOGGER.error("DRIVER is null");
			}
			}
			catch(Exception e){
				LOGGER.error("Enter into main() catch(Exception e) block");
				LOGGER.error("Exception is " + e);
				LOGGER.error("Exit from main() catch(Exception e) block");
			}
			finally{
				DRIVER.close();
				DRIVER.quit();
			}
			/*<select name="country" size="1">
			<option value="ALBANIA">ALBANIA</option>
			<option value="ALGERIA">ALGERIA</option>
			<option value="AMERICAN SAMOA">AMERICAN SAMOA</option>
			<option value="ANDORRA">ANDORRA</option>
			<option value="ANGOLA">ANGOLA</option>
			<option value="ANGUILLA">ANGUILLA</option>
			<option value="ANTARCTICA">ANTARCTICA</option>
			<option value="ANTIGUA AND BARBUDA">ANTIGUA AND BARBUDA</option>
			<option value="ARGENTINA">ARGENTINA</option>
			<option value="ARMENIA">ARMENIA</option>
			<option value="ARUBA">ARUBA</option>
			<option value="ASHMORE AND CARTIER ISLANDS">ASHMORE AND CARTIER ISLANDS</option>
			<option value="AUSTRALIA">AUSTRALIA</option>
			<option value="AUSTRIA">AUSTRIA</option>
			<option value="AZERBAIJAN">AZERBAIJAN</option>
			<option value="BAHAMAS">BAHAMAS</option>
			<option value="BAHRAIN">BAHRAIN</option>
			<option value="BAKER ISLAND">BAKER ISLAND</option>
			<option value="BANGLADESH">BANGLADESH</option>
			<option value="BARBADOS">BARBADOS</option>
			<option value="BASSA DE INDIA">BASSA DE INDIA</option>
			<option value="BELARUS">BELARUS</option>
			<option value="BELGIUM">BELGIUM</option>
			<option value="BELIZE">BELIZE</option>
			<option value="BENIN">BENIN</option>
			<option value="BERMUDA">BERMUDA</option>
			<option value="BHUTAN">BHUTAN</option>
			<option value="BOLIVIA">BOLIVIA</option>
			<option value="BOSNIA AND HERZEGOVINA">BOSNIA AND HERZEGOVINA</option>
			<option value="BOTSWANA">BOTSWANA</option>
			<option value="BOUVET ISLAND">BOUVET ISLAND</option>
			<option value="BRAZIL">BRAZIL</option>
			<option value="BRITISH INDIAN OCEAN TERRITORY">BRITISH INDIAN OCEAN TERRITORY</option>
			<option value="BRITISH VIRGIN ISLANDS">BRITISH VIRGIN ISLANDS</option>
			<option value="BRUNEI">BRUNEI</option>
			<option value="BULGARIA">BULGARIA</option>
			<option value="BURKINA FASO">BURKINA FASO</option>
			<option value="BURMA">BURMA</option>
			<option value="BURUNDI">BURUNDI</option>
			<option value="CAMBODIA">CAMBODIA</option>
			<option value="CAMEROON">CAMEROON</option>
			<option value="CANADA">CANADA</option>
			<option value="CAPE VERDE">CAPE VERDE</option>
			<option value="CAYMAN ISLANDS">CAYMAN ISLANDS</option>
			<option value="CENTRAL AFRICAN REPUBLIC">CENTRAL AFRICAN REPUBLIC</option>
			<option value="CHAD">CHAD</option>
			<option value="CHILE">CHILE</option>
			<option value="CHINA">CHINA</option>
			<option value="CHRISTMAS ISLAND">CHRISTMAS ISLAND</option>
			<option value="CLIPPERTON ISLAND">CLIPPERTON ISLAND</option>
			<option value="COCOS (KEELING) ISLANDS">COCOS (KEELING) ISLANDS</option>
			<option value="COLOMBIA">COLOMBIA</option>
			<option value="COMOROS">COMOROS</option>
			<option value="CONGO">CONGO</option>
			<option value="COOK ISLANDS">COOK ISLANDS</option>
			<option value="CORAL SEA ISLANDS">CORAL SEA ISLANDS</option>
			<option value="COSTA RICA">COSTA RICA</option>
			<option value="COTE D'IVOIRE">COTE D'IVOIRE</option>
			<option value="CROATIA">CROATIA</option>
			<option value="CUBA">CUBA</option>
			<option value="CYPRUS">CYPRUS</option>
			<option value="CZECH REPUBLIC">CZECH REPUBLIC</option>
			<option value="DENMARK">DENMARK</option>
			<option value="DJIBOUTI">DJIBOUTI</option>
			<option value="DOMINICA">DOMINICA</option>
			<option value="DOMINICAN REPUBLIC">DOMINICAN REPUBLIC</option>
			<option value="ECUADOR">ECUADOR</option>
			<option value="EGYPT">EGYPT</option>
			<option value="EL SALVADOR">EL SALVADOR</option>
			<option value="EQUATORIAL GUINEA">EQUATORIAL GUINEA</option>
			<option value="ERITREA">ERITREA</option>
			<option value="ESTONIA">ESTONIA</option>
			<option value="ETHIOPIA">ETHIOPIA</option>
			<option value="EUROPA ISLAND">EUROPA ISLAND</option>
			<option value="FALKLAND ISLANDS">FALKLAND ISLANDS</option>
			<option value="FAROE ISLANDS">FAROE ISLANDS</option>
			<option value="FIJI">FIJI</option>
			<option value="FINLAND">FINLAND</option>
			<option value="FRANCE">FRANCE</option>
			<option value="FRENCH GUIANA">FRENCH GUIANA</option>
			<option value="FRENCH POLYNESIA">FRENCH POLYNESIA</option>
			<option value="FRENCH SOUTHERN AND ANTARCTIC LANDS">FRENCH SOUTHERN AND ANTARCTIC LANDS</option>
			<option value="GABON">GABON</option>
			<option value="GAMBIA, THE">GAMBIA, THE</option>
			<option value="GAZA STRIP">GAZA STRIP</option>
			<option value="GEORGIA">GEORGIA</option>
			<option value="GERMANY">GERMANY</option>
			<option value="GHANA">GHANA</option>
			<option value="GIBRALTAR">GIBRALTAR</option>
			<option value="GLORIOSO ISLANDS">GLORIOSO ISLANDS</option>
			<option value="GREECE">GREECE</option>
			<option value="GREENLAND">GREENLAND</option>
			<option value="GRENADA">GRENADA</option>
			<option value="GUADELOUPE">GUADELOUPE</option>
			<option value="GUAM">GUAM</option>
			<option value="GUATEMALA">GUATEMALA</option>
			<option value="GUERNSEY">GUERNSEY</option>
			<option value="GUINEA">GUINEA</option>
			<option value="GUINEA-BISSAU">GUINEA-BISSAU</option>
			<option value="GUYANA">GUYANA</option>
			<option value="HAITI">HAITI</option>
			<option value="HEARD ISLAND AND MCDONALD ISLANDS">HEARD ISLAND AND MCDONALD ISLANDS</option>
			<option value="HONDURAS">HONDURAS</option>
			<option value="HONG KONG">HONG KONG</option>
			<option value="HOWLAND ISLAND">HOWLAND ISLAND</option>
			<option value="HUNGARY">HUNGARY</option>
			<option value="ICELAND">ICELAND</option>
			<option value="INDIA">INDIA</option>
			<option value="INDONESIA">INDONESIA</option>
			<option value="IRAN">IRAN</option>
			<option value="IRAQ">IRAQ</option>
			<option value="IRELAND">IRELAND</option>
			<option value="ISRAEL">ISRAEL</option>
			<option value="ITALY">ITALY</option>
			<option value="JAMAICA">JAMAICA</option>
			<option value="JAN MAYEN">JAN MAYEN</option>
			<option value="JAPAN">JAPAN</option>
			<option value="JARVIS ISLAND">JARVIS ISLAND</option>
			<option value="JERSEY">JERSEY</option>
			<option value="JOHNSTON ATOLL">JOHNSTON ATOLL</option>
			<option value="JORDAN">JORDAN</option>
			<option value="JUAN DE NOVA ISLAND">JUAN DE NOVA ISLAND</option>
			<option value="KAZAKHSTAN">KAZAKHSTAN</option>
			<option value="KENYA">KENYA</option>
			<option value="KINGMAN REEF">KINGMAN REEF</option>
			<option value="KIRIBATI">KIRIBATI</option>
			<option value="KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF">KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF</option>
			<option value="KOREA, REPUBLIC OF">KOREA, REPUBLIC OF</option>
			<option value="KUWAIT">KUWAIT</option>
			<option value="KYRGYZSTAN">KYRGYZSTAN</option>
			<option value="LAOS">LAOS</option>
			<option value="LATVIA">LATVIA</option>
			<option value="LEBANON">LEBANON</option>
			<option value="LESOTHO">LESOTHO</option>
			<option value="LIBERIA">LIBERIA</option>
			<option value="LIBYA">LIBYA</option>
			<option value="LIECHTENSTEIN">LIECHTENSTEIN</option>
			<option value="LITHUANIA">LITHUANIA</option>
			<option value="LUXEMBOURG">LUXEMBOURG</option>
			<option value="MACAU">MACAU</option>
			<option value="MACEDONIA, FORMER REPUBLIC OF">MACEDONIA, FORMER REPUBLIC OF</option>
			<option value="MADAGASCAR">MADAGASCAR</option>
			<option value="MALAWI">MALAWI</option>
			<option value="MALAYSIA">MALAYSIA</option>
			<option value="MALDIVES">MALDIVES</option>
			<option value="MALI">MALI</option>
			<option value="MALTA">MALTA</option>
			<option value="MAN, ISLE OF">MAN, ISLE OF</option>
			<option value="MARSHALL ISLANDS">MARSHALL ISLANDS</option>
			<option value="MARTINIQUE">MARTINIQUE</option>
			<option value="MAURITANIA">MAURITANIA</option>
			<option value="MAURITIUS">MAURITIUS</option>
			<option value="MAYOTTE">MAYOTTE</option>
			<option value="MEXICO">MEXICO</option>
			<option value="MICRONESIA">MICRONESIA</option>
			<option value="MIDWAY ISLANDS">MIDWAY ISLANDS</option>
			<option value="MOLDOVA">MOLDOVA</option>
			<option value="MONACO">MONACO</option>
			<option value="MONGOLIA">MONGOLIA</option>
			<option value="MONTENEGRO">MONTENEGRO</option>
			<option value="MONTSERRAT">MONTSERRAT</option>
			<option value="MOROCCO">MOROCCO</option>
			<option value="MOZAMBIQUE">MOZAMBIQUE</option>
			<option value="NAMIBIA">NAMIBIA</option>
			<option value="NAURU">NAURU</option>
			<option value="NAVASSA ISLAND">NAVASSA ISLAND</option>
			<option value="NEPAL">NEPAL</option>
			<option value="NETHERLANDS">NETHERLANDS</option>
			<option value="NETHERLANDS ANTILLES">NETHERLANDS ANTILLES</option>
			<option value="NEW CALEDONIA">NEW CALEDONIA</option>
			<option value="NEW ZEALAND">NEW ZEALAND</option>
			<option value="NICARAGUA">NICARAGUA</option>
			<option value="NIGER">NIGER</option>
			<option value="NIGERIA">NIGERIA</option>
			<option value="NIUE">NIUE</option>
			<option value="NO MANS LAND">NO MANS LAND</option>
			<option value="NORFOLK ISLAND">NORFOLK ISLAND</option>
			<option value="NORTHERN MARIANA ISLANDS">NORTHERN MARIANA ISLANDS</option>
			<option value="NORWAY">NORWAY</option>
			<option value="OCEANS">OCEANS</option>
			<option value="OMAN">OMAN</option>
			<option value="PAKISTAN">PAKISTAN</option>
			<option value="PALMYRA ATOLL">PALMYRA ATOLL</option>
			<option value="PANAMA">PANAMA</option>
			<option value="PAPUA NEW GUINEA">PAPUA NEW GUINEA</option>
			<option value="PARACEL ISLANDS">PARACEL ISLANDS</option>
			<option value="PARAGUAY">PARAGUAY</option>
			<option value="PERU">PERU</option>
			<option value="PHILIPPINES">PHILIPPINES</option>
			<option value="PITCAIRN ISLANDS">PITCAIRN ISLANDS</option>
			<option value="POLAND">POLAND</option>
			<option value="PORTUGAL">PORTUGAL</option>
			<option value="PUERTO RICO">PUERTO RICO</option>
			<option value="QATAR">QATAR</option>
			<option value="REUNION">REUNION</option>
			<option value="ROMANIA">ROMANIA</option>
			<option value="RUSSIA">RUSSIA</option>
			<option value="RWANDA">RWANDA</option>
			<option value="SAN MARINO">SAN MARINO</option>
			<option value="SAO TOME AND PRINCIPE">SAO TOME AND PRINCIPE</option>
			<option value="SAUDI ARABIA">SAUDI ARABIA</option>
			<option value="SENEGAL">SENEGAL</option>
			<option value="SERBIA">SERBIA</option>
			<option value="SEYCHELLES">SEYCHELLES</option>
			<option value="SIERRA LEONE">SIERRA LEONE</option>
			<option value="SINGAPORE">SINGAPORE</option>
			<option value="SLOVAKIA">SLOVAKIA</option>
			<option value="SLOVENIA">SLOVENIA</option>
			<option value="SOLOMON ISLANDS">SOLOMON ISLANDS</option>
			<option value="SOMALIA">SOMALIA</option>
			<option value="SOUTH AFRICA">SOUTH AFRICA</option>
			<option value="SOVIET UNION">SOVIET UNION</option>
			<option value="SPAIN">SPAIN</option>
			<option value="SPRATLY ISLANDS">SPRATLY ISLANDS</option>
			<option value="SRI LANKA">SRI LANKA</option>
			<option value="ST. HELENA">ST. HELENA</option>
			<option value="ST. KITTS AND NEVIS">ST. KITTS AND NEVIS</option>
			<option value="ST. LUCIA">ST. LUCIA</option>
			<option value="ST. PIERRE AND MIQUELON">ST. PIERRE AND MIQUELON</option>
			<option value="ST. VINCENT AND THE GRENADINES">ST. VINCENT AND THE GRENADINES</option>
			<option value="SUDAN">SUDAN</option>
			<option value="SURINAME">SURINAME</option>
			<option value="SVALBARD">SVALBARD</option>
			<option value="SWAZILAND">SWAZILAND</option>
			<option value="SWEDEN">SWEDEN</option>
			<option value="SWITZERLAND">SWITZERLAND</option>
			<option value="SYRIA">SYRIA</option>
			<option value="TAIWAN">TAIWAN</option>
			<option value="TAJIKISTAN">TAJIKISTAN</option>
			<option value="TANZANIA, UNITED REPUBLIC OF">TANZANIA, UNITED REPUBLIC OF</option>
			<option value="THAILAND">THAILAND</option>
			<option value="TOGO">TOGO</option>
			<option value="TOKELAU">TOKELAU</option>
			<option value="TONGA">TONGA</option>
			<option value="TRINIDAD AND TOBAGO">TRINIDAD AND TOBAGO</option>
			<option value="TROMELIN ISLAND">TROMELIN ISLAND</option>
			<option value="TUNISIA">TUNISIA</option>
			<option value="TURKEY">TURKEY</option>
			<option value="TURKMENISTAN">TURKMENISTAN</option>
			<option value="TURKS AND CAICOS ISLANDS">TURKS AND CAICOS ISLANDS</option>
			<option value="TUVALU">TUVALU</option>
			<option value="UGANDA">UGANDA</option>
			<option value="UKRAINE">UKRAINE</option>
			<option value="UNDERSEA FEATURES">UNDERSEA FEATURES</option>
			<option value="UNITED ARAB EMIRATES">UNITED ARAB EMIRATES</option>
			<option value="UNITED KINGDOM">UNITED KINGDOM</option>
			<option value="UNITED STATES">UNITED STATES</option>
			<option value="URUGUAY">URUGUAY</option>
			<option value="UZBEKISTAN">UZBEKISTAN</option>
			<option value="VANUATU">VANUATU</option>
			<option value="VATICAN CITY">VATICAN CITY</option>
			<option value="VENEZUELA">VENEZUELA</option>
			<option value="VIETNAM">VIETNAM</option>
			<option value="VIRGIN ISLANDS">VIRGIN ISLANDS</option>
			<option value="WAKE ISLAND">WAKE ISLAND</option>
			<option value="WALLIS AND FUTUNA">WALLIS AND FUTUNA</option>
			<option value="WEST BANK">WEST BANK</option>
			<option value="WESTERN SAHARA">WESTERN SAHARA</option>
			<option value="WESTERN SAMOA">WESTERN SAMOA</option>
			<option value="YEMEN">YEMEN</option>
			<option value="YUGOSLAVIA">YUGOSLAVIA</option>
			<option value="ZAIRE">ZAIRE</option>
			<option value="ZAMBIA">ZAMBIA</option>
			<option value="ZIMBABWE">ZIMBABWE</option>
			</select> */

	}
}
