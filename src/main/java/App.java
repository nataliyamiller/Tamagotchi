import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    model.put("username", request.session().attribute("username"));
    model.put("template", "templates/index.vtl");

    model.put("tamagotchiname", request.session().attribute("tamagotchiname"));
    model.put("template", "templates/index.vtl");


    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/index", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();

    boolean playClicked = Boolean.parseBoolean(request.queryParams("playClicked"));
    boolean restClicked = Boolean.parseBoolean(request.queryParams("restClicked"));
    boolean feedClicked = Boolean.parseBoolean(request.queryParams("feedClicked"));

    if(playClicked) {
      Tamagotchi.play();
      } else if (restClicked) {
      Tamagotchi.rest(); {
      } else if (feedClicked) {
        Tamagotchi.feed();
      }

    model.put("playClicked", playClicked);
    model.put("restClicked", restClicked);
    model.put("feedClicked", feedClicked);


    String newName = request.queryParams("username");
    request.session().attribute("username", newName);
    model.put("username", newName);

    String newTam = request.queryParams("tamagotchiname");
    request.session().attribute("tamagotchiname", newTam);
    model.put("tamagotchiname", newTam);

    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
 }
}
