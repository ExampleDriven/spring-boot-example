@RestController
class Application {

  @RequestMapping('/')
  String home() {
    'Hello World from groovy'
  }

}