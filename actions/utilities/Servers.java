package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:serverConfig/${env}.properties" })
public interface Servers extends Config {
	@Key("App.Url")
	String getAppUrl();
	
	@Key("App.User")
	String getAppUsername();
	
	@Key("App.Pass")
	String getAppPassword();
	
	@Key("DB.Host")
	String getDBHostName();
	
	@Key("DB.User")
	String getDBUsername();
	
	@Key("DB.Pass")
	String getDBPassword();
	
}
