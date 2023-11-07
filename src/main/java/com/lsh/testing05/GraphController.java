package com.lsh.testing05;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsh.testing05.graph.service.GraphService;
import com.lsh.testing05.graph.vo.GraphVO;



@RestController
public class GraphController {

	
	@Inject
	GraphService service;
	
	private static final Logger logger = LoggerFactory.getLogger(GraphController.class);
	
	@RequestMapping(value = "/SearchGraph", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public List<GraphVO> SearchGraphList(@RequestBody GraphVO vo) throws Exception {
		
		
		if(vo.getSPECIAL_PROCESS_NAME().equals("-")) {
			
			vo.setSPECIAL_PROCESS_NAME("");
		}

		if(vo.getSPECIAL_EQUIPMENT_NAME().equals("-")) {
			
			vo.setSPECIAL_EQUIPMENT_NAME("");
			
		}
		
		if(vo.getSPECIAL_BELLOWS_MATERIAL_NAME().equals("-")) {
			
			vo.setSPECIAL_BELLOWS_MATERIAL_NAME("");
		}
		
		if(vo.getSPECIAL_OD_RANGE_NAME().equals("-")) {
			
			vo.setSPECIAL_OD_RANGE_NAME("");
		}
		if(vo.getSPECIAL_THICKNESS_NAME().equals("-")) {
			
			vo.setSPECIAL_THICKNESS_NAME("");
		}
		
		return service.SearchGraph(vo);
	
	}
	
	
	@RequestMapping(value = "/ProcessList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<GraphVO> ProcessList(GraphVO vo) throws Exception {
		
		
		return service.ProcessList(vo);
	}
	
	
	@RequestMapping(value = "/EquipmentList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<GraphVO> EquipmentList(GraphVO vo) throws Exception {
		
		return service.EquipmentList(vo);
	}
	
	
	@RequestMapping(value = "/MaterialList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<GraphVO> MaterialList(GraphVO vo) throws Exception {
		
		return service.MaterialList(vo);
	}
		
	@RequestMapping(value = "/ODRangeList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<GraphVO> ODRangeList(GraphVO vo) throws Exception {
		
		return service.ODRangeList(vo);
		
	}
		
	@RequestMapping(value = "/ThicknessList", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<GraphVO> ThicknessList(GraphVO vo) throws Exception {
		
		return service.ThicknessList(vo);
		
	}
}
