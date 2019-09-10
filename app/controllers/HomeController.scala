package controllers

import javax.inject._
import play.api.i18n.I18nSupport
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController
  with I18nSupport {

  val index: Action[AnyContent] = Action { implicit request =>
    Ok(views.html.index("Your new application is ready."))
  }
}
