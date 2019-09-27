package controllers

import javax.inject._
import models._
import models.cards.{AutomatedTest, Deployment, LibraryDependencies, Microservice}
import play.api.i18n.I18nSupport
import play.api.mvc._

@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents)
  extends BaseController
  with I18nSupport {

  val index: Action[AnyContent] = Action { implicit request =>

    val deployments = Deployments(
      dev = Some(Deployment("Development", "0.1.0", Red, "11th September 2019, 14:23pm")),
      qa = Some(Deployment("QA","0.1.0", Green, "11th September 2019, 14:23pm")),
      staging = Some(Deployment("Staging", "0.1.0", Amber, "11th September 2019, 14:23pm")),
      production = Some(Deployment("Production","0.1.0", Green, "11th September 2019, 14:23pm"))
    )

    val automatedTests = AutomatedTests(
      acceptance = Some(AutomatedTest("manage-vat-acceptance-tests", "11th September 2019, 14:23pm", Red)),
      smoke = None,
      performance = Some(AutomatedTest("manage-vat-acceptance-tests", "11th September 2019, 14:23pm", Amber))
    )

    val cardRow = Pipeline(
      microservice = Microservice("Manage VAT Subscription Frontend", "description", "11th September 2019, 14:23pm"),
      libraryDependencies = LibraryDependencies(5, 2),
      deployments = deployments,
      automatedTests = automatedTests
    )

    Ok(views.html.dashboard(Seq(cardRow, cardRow, cardRow)))
  }
}
