package dt.uqi.kotlinIntro

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/intro")
class IntroController {

    @GetMapping("/get")
    fun introFunction(): String = "Function string returned from endpoint"
}