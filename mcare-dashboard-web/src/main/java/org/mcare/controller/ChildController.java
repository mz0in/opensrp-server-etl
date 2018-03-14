package org.mcare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.util.ControllerUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.ActionEntity;
import org.mcare.etl.entity.ChildEntity;
import org.mcare.etl.entity.ENCCEntity;
import org.mcare.etl.service.ActionService;
import org.mcare.etl.service.ChildService;
import org.mcare.etl.service.ENCCService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChildController {

	private static final String CHILD = "Child";

	private static final String CHILD_HTML = "child.html";

	@Autowired
	private ChildService childService;

	@Autowired
	private ENCCService enccService;

	@Autowired
	private ActionService actionService;

	@Autowired
	private PaginationUtil paginationUtil;

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Autowired
	private ProviderServiceImpl providerServiceImpl;

	@Autowired
	private SearchBuilder searchBuilder;

	public ChildController() {

	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_CHILD_LIST')")
	@RequestMapping(value = "/child.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		ControllerUtil.setSessionAttributes(session, CHILD_HTML, CHILD);
		Class<ChildEntity> entityClassName = ChildEntity.class;
		paginationUtil.createPagination(request, session, entityClassName);
		return "child/index";
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_CHILD')")
	@RequestMapping(value = "child/{id}/view.html", method = RequestMethod.GET)
	public String view(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		session.setAttribute("title", "Child Details");
		ChildEntity child = childService.findById(id);
		model.addAttribute("child", child);
		return "child/view";
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_CHILD')")
	@RequestMapping(value = "child/{id}/visits.html", method = RequestMethod.GET)
	public String visitsPending(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		ChildEntity child = childService.findById(id);
		session.setAttribute("child", child);

		session.setAttribute("title", "Pending Visits");
		List<ActionEntity> actionlist = actionService.findAllPendingChildVisits(child.getCaseId(), child.getProvider());
		session.setAttribute("actionlist", actionlist);

		if (actionlist != null && !actionlist.isEmpty()) {
			return "child/visits";
		} else {
			return "/notfound";
		}
	}

	@PostAuthorize("hasPermission(returnObject, 'PERM_READ_CHILD')")
	@RequestMapping(value = "child/{id}/encc.html", method = RequestMethod.GET)
	public String encc(HttpServletRequest request, HttpSession session, Model model, @PathVariable("id") int id) {
		ChildEntity child = childService.findById(id);
		session.setAttribute("child", child);
		session.setAttribute("title", "ENCC Information");

		List<ENCCEntity> encclist = enccService.findByRelationalId(child.getCaseId());
		session.setAttribute("encclist", encclist);

		if (encclist != null && !encclist.isEmpty()) {
			return "child/encc";
		} else {
			return "/notfound";
		}
	}
}

