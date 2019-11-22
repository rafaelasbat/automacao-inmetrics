package pages.DesafioWebservice;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonParser;

public class AcessarAPIPage {

	String endPoint = null;
	
	JsonArray jsonArray = null;

	public String api() {
		endPoint = "https://swapi.co/api/films/";

		return (endPoint);
	}

	public JsonArray  get() {
		String resposta = given().relaxedHTTPSValidation().when().get(endPoint).then().statusCode(200).extract().body()
				.asString();

		JsonParser jsonParser = new JsonParser();

		jsonArray = jsonParser.parse(resposta).getAsJsonObject().get("results").getAsJsonArray();
		
		return(jsonArray);

	}

	public void getTitles() {

		List<String> titulos = new ArrayList<String>();

		for (JsonElement element : jsonArray) {

			titulos.add("Title: " + element.getAsJsonObject().get("title").toString() + "\n");

		}

		System.out.println(titulos);

	}

	public void filterTitle() {

		List<String> titulos = new ArrayList<String>();

		for (JsonElement element : jsonArray) {

			String diretor = element.getAsJsonObject().get("director").getAsString();

			String produtor = element.getAsJsonObject().get("producer").getAsString();

			if (diretor.equals("George Lucas") && produtor.contains("Rick McCallum")) {

				titulos.add("Title: " + element.getAsJsonObject().get("title").getAsString() + "\n");
			}

		}

		System.out.println(titulos);
	}
}
