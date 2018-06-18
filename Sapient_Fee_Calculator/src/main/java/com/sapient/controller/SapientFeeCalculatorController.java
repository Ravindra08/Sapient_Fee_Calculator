/**
 * 
 */
package com.sapient.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.bean.TransactionBean;
import com.sapient.constant.IConstant;
import com.sapient.error.ErrorCodeResponse;
import com.sapient.service.SapientFeeCalculatorService;

/**
 * @author RAVINDRA.SINGH
 *  RA20004613
 *
 */
@RestController
@Description("Controller Class : Accepts JSON for Text Data")
public class SapientFeeCalculatorController {

	private static final Logger logger = LoggerFactory.getLogger(SapientFeeCalculatorController.class);
	@Autowired
	SapientFeeCalculatorService sapientFeeCalculatorService;
	TransactionBean objTransactionBean = null;
	List<TransactionBean> listBean = null;
	TransactionBean transactionAttributes = null;
	
	@RequestMapping(value = IConstant.URL, method = RequestMethod.POST,headers="Accept=application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public List<TransactionBean> textFeeCalculator(@RequestBody String payload, HttpServletResponse response)
			throws IOException {
		logger.info("JSON Request : "+ payload );
		ObjectMapper mapper = new ObjectMapper();
		objTransactionBean = mapper.readValue(payload, TransactionBean.class);
		listBean = objTransactionBean.getTransactionBeanList();
		String headerValue = CacheControl.maxAge(10, TimeUnit.SECONDS).getHeaderValue();
		response.addHeader("Cache-Control", headerValue);
		response.addHeader("pragma", "no-cache");
		response.addHeader("expires", "-1");
		return sapientFeeCalculatorService.calculateTransactionFee(listBean);
	}
	/*
	 * Method: handleException() Des : Here handle the exception if user provide
	 * invalid data.
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleException(Exception e) {
		ObjectMapper mapper = new ObjectMapper();
		String json = IConstant.BLANKSPACE;
		try {
			ErrorCodeResponse response = new ErrorCodeResponse(IConstant.ERRORCODE, e.getMessage());
			json = mapper.writeValueAsString(response);
			logger.info(" ErrorCodeResponse : "+ response );
		} catch (JsonProcessingException e1) {
			logger.info(" JsonProcessingException : "+ e1 );
		}
		return new ResponseEntity<>(json + "\n", HttpStatus.BAD_REQUEST);
	}

}
