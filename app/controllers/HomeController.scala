package controllers

import javax.inject._
import models._
import play.api.i18n.I18nSupport
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController
  with I18nSupport {

  val index: Action[AnyContent] = Action { implicit request =>
    val cardRow = (AppInfoCard("name", "description", "author"), Seq(
      AppVersionCard("Manage VAT Subscription Frontend", "0.1.0", "11th September 2019", Red),
      AppVersionCard("Deregister VAT Frontend", "0.5.0", "10th September 2019", Amber),
      AppVersionCard("VAT Summary Frontend", "0.10.0", "9th September 2019", Green)
    ))

    Ok(views.html.dashboard(Seq(cardRow, cardRow, cardRow)))
  }
}
