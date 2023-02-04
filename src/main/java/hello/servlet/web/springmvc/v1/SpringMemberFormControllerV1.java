package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 아래 두 어노테이션이 있으면 핸들러로 매핑이 된다 (RequestMappingHandlerMapping)
//@Component
//@RequestMapping

// 컨트롤러 어노테이션은 둘 다를 포함하고 있다.
@Controller

public class SpringMemberFormControllerV1 {

	@RequestMapping("/springmvc/v1/members/new-form")
	public ModelAndView process() {
		return new ModelAndView("new-form");
	}
}
