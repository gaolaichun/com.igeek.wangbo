package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sm.model.BodyQualifications;
import com.sm.model.IndustryQualification;
import com.sm.model.PersonalQualification;
import com.sm.model.SpecialQualification;
import com.sm.service.BodyQualificationsService;
import com.sm.service.IndustryQualificationService;
import com.sm.service.PersonalQualificationService;
import com.sm.service.SpecialQualificationService;
import com.sm.util.CommonUtil;
import com.sm.util.Msg;

@Controller
@RequestMapping("/qualification")
public class QualificationController {

	@Autowired
	private IndustryQualificationService industryQualificationService;

	@Autowired
	private BodyQualificationsService bodyQualificationsService;

	@Autowired
	private SpecialQualificationService specialQualificationService;

	@Autowired
	private PersonalQualificationService personalQualificationService;

	/**
	 * 短信验证
	 * 
	 * @param phone 手机号
	 * @param code  验证码
	 * @return
	 */
	@RequestMapping("/checkCode")
	@ResponseBody
	public Msg checkCode(String phone, String code) {
		if (phone == null || code == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		String msg = CommonUtil.verifyMobileCode(phone, code);
		if (msg != null) {
			return Msg.fail().add("msg", msg);
		}
		return Msg.success();
	}

	/**
	 * 查询资质信息
	 * 
	 * @param id 行业资质表ID
	 * @return
	 */
	@RequestMapping(value = "/selectAllQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectAllQualification(Integer sid) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 执行sql,查询行业资质表
		BodyQualifications BQ = bodyQualificationsService.selectByPrimaryKey(sid);
		// 执行sql,查询主体资质表
		IndustryQualification IQ = industryQualificationService.selectByPrimaryKey(sid);
		// 执行sql,查询特殊资质表
		SpecialQualification SQ = specialQualificationService.selectByPrimaryKey(sid);

		if (BQ == null || IQ == null || SQ == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("BodyQualifications", BQ).add("IndustryQualification", IQ).add("SpecialQualification",
				SQ);

	}

	/**
	 * 查询行业资质
	 * 
	 * @param id 行业资质表ID
	 * @return
	 */
	@RequestMapping(value = "/selectIndusQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectIndustryQualification(Integer sid) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//执行sql
		IndustryQualification industryQualification = industryQualificationService.selectByPrimaryKey(sid);

		if (industryQualification == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("industryQualification", industryQualification);

	}

	/**
	 * 查询主体资质
	 * 
	 * @param sid 商家表ID
	 * @return
	 */
	@RequestMapping(value = "/selectBodyQualifications", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectBodyQualifications(Integer sid) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//执行sql
		BodyQualifications bodyQualifications = bodyQualificationsService.selectByPrimaryKey(sid);
		System.out.println("------" + bodyQualifications);
		if (bodyQualifications == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("bodyQualifications", bodyQualifications);

	}

	/**
	 * 查询特殊资质
	 * 
	 * @param id 特殊资质表ID
	 * @return
	 */
	@RequestMapping(value = "/selectSpeQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg selectSpeQualification(Integer sid) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//执行sql
		SpecialQualification specialQualification = specialQualificationService.selectByPrimaryKey(sid);

		if (specialQualification == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("specialQualification", specialQualification);

	}

	/**
	 * 添加行业资质
	 * 
	 * @param sid             门店ID
	 * @param imgStr          图片base64
	 * @param certificateType 证件类型
	 * @param licenseNumber   许可证编号
	 * @param unitName        单位名称
	 * @param legalPerson     法人
	 * @param premises        经营场所
	 * @param businessProject 经营项目
	 * @param licensePeriod   执照期限
	 * @return
	 */

	@RequestMapping(value = "/insertIndusQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertIndusQualification(Integer sid, String imgStr, String certificateType, String licenseNumber,
			String unitName, String legalPerson, String premises, String businessProject, String licensePeriod) {

		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		IndustryQualification industryQualification = new IndustryQualification();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		// 设置门店ID
		industryQualification.setSid(sid);
		// 设置证件类型
		industryQualification.setCertificateType(certificateType);
		// 设置图片
		industryQualification.setCertificatePicture(path);
		// 设置许可证编号
		industryQualification.setLicenseNumber(licenseNumber);
		// 设置单位名称
		industryQualification.setUnitName(unitName);
		// 设置法人
		industryQualification.setLegalPerson(legalPerson);
		// 设置经营场所
		industryQualification.setPremises(premises);
		// 设置经营项目
		industryQualification.setBusinessProject(businessProject);
		// 设置执照期限
		industryQualification.setLicensePeriod(licensePeriod);
		// 执行sql
		int val = industryQualificationService.insertSelective(industryQualification);

		if (val == 1) {
			return Msg.success().add("msg", "添加成功！");
		} else {
			return Msg.fail().add("msg", "添加失败！");
		}
	}

	/**
	 * 修改行业资质
	 * 
	 * @param sid             门店ID
	 * @param certificateType 证件类型
	 * @param imgStr          证件图片base64
	 * @param licenseNumber   许可证编号
	 * @param unitName        单位名称
	 * @param legalPerson     法人
	 * @param premises        经营场所
	 * @param businessProject 经营项目
	 * @param licensePeriod   执照期限
	 * @return
	 */

	@RequestMapping(value = "/updateIndusQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateIndustryQualification(Integer sid, String certificateType, String imgStr, String licenseNumber,
			String unitName, String legalPerson, String premises, String businessProject, String licensePeriod) {

		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		IndustryQualification industryQualification = new IndustryQualification();
		// 设置门店ID
		industryQualification.setSid(sid);
		// 设置证件类型
		industryQualification.setCertificateType(certificateType);
		// 设置许可证编号
		industryQualification.setLicenseNumber(licenseNumber);
		// 设置单位名称
		industryQualification.setUnitName(unitName);
		// 设置法人
		industryQualification.setLegalPerson(legalPerson);
		// 设置经营场所
		industryQualification.setPremises(premises);
		// 设置经营项目
		industryQualification.setBusinessProject(businessProject);
		// 设置执照期限
		industryQualification.setLicensePeriod(licensePeriod);
		// 执行sql
		int val = industryQualificationService.updateByPrimaryKeySelective(industryQualification);

		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 添加主体资质
	 * 
	 * @param sid                门店ID
	 * @param imgStr             图片base64
	 * @param certificateType    证件类型
	 * @param registrationNumber 注册号
	 * @param unitName           单位名称
	 * @param legalPerson        法人
	 * @param premises           经营场所
	 * @param businessProject    经营项目
	 * @param licensePeriod      执照期限
	 * @return
	 */
	@RequestMapping(value = "/insertBodyQualifications", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertBodyQualifications(Integer sid, String imgStr, String certificateType, String registrationNumber,
			String unitName, String legalPerson, String premises, String licensePeriod) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		BodyQualifications bodyQualifications = new BodyQualifications();
		// 设置门店ID
		bodyQualifications.setSid(sid);
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		bodyQualifications.setCertificatePicture(path);
		// 设置证件类型
		bodyQualifications.setCertificateType(certificateType);
		// 设置注册号
		bodyQualifications.setRegistrationNumber(registrationNumber);
		// 设置单位名称
		bodyQualifications.setUnitName(unitName);
		// 设置法人
		bodyQualifications.setLegalPerson(legalPerson);
		// 设置经营场所
		bodyQualifications.setPremises(premises);
		// 设置执照期限
		bodyQualifications.setLicensePeriod(licensePeriod);
		// 执行sql
		int val = bodyQualificationsService.insertSelective(bodyQualifications);
		if (val == 1) {
			return Msg.success().add("msg", "添加成功！");
		} else {
			return Msg.fail().add("msg", "添加失败！");
		}
	}

	/**
	 * 修改主体资质
	 * 
	 * @param sid                商家ID
	 * @param certificateType    证件类型
	 * @param registrationNumber 注册号
	 * @param unitName           单位名称
	 * @param legalPerson        法人
	 * @param premises           经营场所
	 * @param businessProject    经营项目
	 * @param licensePeriod      执照期限
	 * @return
	 */
	@RequestMapping(value = "/updateBodyQualifications", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateBodyQualifications(Integer sid, String certificateType, String registrationNumber, String unitName,
			String legalPerson, String premises, String licensePeriod) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		BodyQualifications bodyQualifications = new BodyQualifications();
//		String path = CommonUtil.pathUrl();
//		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		// 设置门店ID
		bodyQualifications.setSid(sid);
		// 设置证件类型
		bodyQualifications.setCertificateType(certificateType);
//		bodyQualifications.setCertificatePicture(path);
		// 设置注册号
		bodyQualifications.setRegistrationNumber(registrationNumber);
		// 设置单位名称
		bodyQualifications.setUnitName(unitName);
		// 设置法人
		bodyQualifications.setLegalPerson(legalPerson);
		// 设置经营场所
		bodyQualifications.setPremises(premises);
		// 设置执照期限
		bodyQualifications.setLicensePeriod(licensePeriod);
		// 执行sql
		int val = bodyQualificationsService.updateByPrimaryKey(bodyQualifications);
		if (val == 1) {
			return Msg.success().add("msg", "修改成功！");
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 添加特殊资质
	 * 
	 * @param sid                 门店ID
	 * @param imgStr              图片base64
	 * @param certificateType     证件类型
	 * @param licenseNumber       许可证编号
	 * @param unitName            单位名称
	 * @param premises            经营场所
	 * @param legalPerson         法人
	 * @param licensePeriod       营业期限
	 * @param certificationStatus 证件审核状态
	 * @return
	 */

	@RequestMapping(value = "/insertSpeQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertSpeQualification(Integer sid, String imgStr, String certificateType, String licenseNumber,
			String unitName, String premises, String legalPerson, String licensePeriod, Integer certificationStatus) {
		// 判断参数是否为空
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		SpecialQualification iQ = new SpecialQualification();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		// 设置门店ID
		iQ.setSid(sid);
		// 设置证件类型
		iQ.setCertificateType(certificateType);
		// 设置许可证编号
		iQ.setLicenseNumber(licenseNumber);
		iQ.setCertificatePicture(path);
		// 设置单位名称
		iQ.setUnitName(unitName);
		// 设置经营场所
		iQ.setPremises(premises);
		// 设置法人
		iQ.setLegalPerson(legalPerson);
		// 设置营业期限
		iQ.setLicensePeriod(licensePeriod);
		// 设置证件审核状态
		iQ.setCertificationStatus(certificationStatus);
		//执行sql
		int val = specialQualificationService.insertSelective(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 修改特殊资质
	 * 
	 * @param sid                 门店ID
	 * @param certificateType     证件类型
	 * @param licenseNumber       许可证编号
	 * @param unitName            单位名称
	 * @param premises            经营场所
	 * @param legalPerson         法人
	 * @param licensePeriod       营业期限
	 * @param certificationStatus 证件审核状态
	 * @return
	 */

	@RequestMapping(value = "/updateSpeQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateSpeQualification(Integer sid, String certificateType, String licenseNumber, String unitName,
			String premises, String legalPerson, String licensePeriod, Integer certificationStatus) {

		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		SpecialQualification iQ = new SpecialQualification();
//		String path = CommonUtil.pathUrl();
//		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		// 设置门店ID
		iQ.setSid(sid);
		// 设置证件类型
		iQ.setCertificateType(certificateType);
		// 设置许可证编号
		iQ.setLicenseNumber(licenseNumber);
//				iQ.setCertificatePicture(path);
		// 设置单位名称
		iQ.setUnitName(unitName);
		// 设置经营场所
		iQ.setPremises(premises);
		// 设置法人
		iQ.setLegalPerson(legalPerson);
		// 设置营业期限
		iQ.setLicensePeriod(licensePeriod);
		// 设置证件审核状态
		iQ.setCertificationStatus(certificationStatus);
		// 执行sql
		int val = specialQualificationService.updateByPrimaryKeySelective(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 添加个人身份认证
	 * 
	 * @param sid                 门店ID
	 * @param imgStr              图片base64
	 * @param certificateType     证件类型
	 * @param realname            真实姓名
	 * @param certificateNo       证件号码
	 * @param idcardPicone        身份证正面照
	 * @param idcardPictwo        身份证反面照
	 * @param certificationStatus 证件审核状态
	 * @return
	 */
	@RequestMapping(value = "/insertPersonQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg insertPersonQualification(Integer sid, String imgStr, String certificateType, String realname,
			String certificateNo, String idcardPicone, String idcardPictwo, Integer certificationStatus) {
		// 判断参数是否为空
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		PersonalQualification PQ = new PersonalQualification();
		// 设置门店ID
		PQ.setSid(sid);
		// 设置证件类型
		PQ.setCertificateType(certificateType);
		// 设置真实姓名
		PQ.setRealname(realname);
		// 设置证件号码
		PQ.setCertificateNo(certificateNo);
		// 设置身份证正面照
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		PQ.setIdcardPicone(path);
		// 设置身份证反面照
		String path2 = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path2);
		PQ.setIdcardPictwo(path2);
		// 设置证件审核状态
		PQ.setCertificationStatus(certificationStatus);
		//执行sql
		int val = personalQualificationService.insertSelective(PQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 修改个人身份认证
	 * 
	 * @param sid                 门店ID
	 * @param imgStr              图片base64
	 * @param certificateType     证件类型
	 * @param realname            真实姓名
	 * @param certificateNo       证件号码
	 * @param idcardPicone        身份证正面照
	 * @param idcardPictwo        身份证反面照
	 * @param certificationStatus 证件审核状态
	 * @return
	 */
	@RequestMapping(value = "/updatePersonQualification", method = RequestMethod.POST)
	@ResponseBody
	public Msg updatePersonQualification(Integer sid, String certificateType, String realname, String certificateNo,
			Integer certificationStatus) {
		// 判断参数是否为空
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		PersonalQualification PQ = new PersonalQualification();
		// 设置门店ID
		PQ.setSid(sid);
		// 设置证件类型
		PQ.setCertificateType(certificateType);
		// 设置真实姓名
		PQ.setRealname(realname);
		// 设置证件号码
		PQ.setCertificateNo(certificateNo);
		// 设置证件审核状态
		PQ.setCertificationStatus(certificationStatus);
		//执行sql
		int val = personalQualificationService.updateByPrimaryKeySelective(PQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 重新上传行业资质的证件图片
	 * 
	 * @param sid    商家ID
	 * @param imgStr 证件图片base64
	 * @return
	 */

	@RequestMapping("/updateIndusCertiPicture")
	@ResponseBody
	public Msg updateIndusCertiPicture(Integer sid, String imgStr) {
		// 创建一个对象
		IndustryQualification iQ = new IndustryQualification();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		iQ.setId(sid);
		iQ.setCertificatePicture(path);
		//执行sql
		int val = industryQualificationService.updateByPrimaryKeySelective(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 重新上传主体资质的证件图片
	 * 
	 * @param sid    商家ID
	 * @param imgStr 证件图片base64
	 * @return
	 */
	@RequestMapping("/updateBdCertificatePicture")
	@ResponseBody
	public Msg updateCertificatePicture(Integer sid, String imgStr) {
		// 创建一个对象
		BodyQualifications BQ = new BodyQualifications();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		BQ.setId(sid);
		BQ.setCertificatePicture(path);
		//执行sql
		int val = bodyQualificationsService.updateByPrimaryKeySelective(BQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 重新上传特殊资质的证件图片
	 * 
	 * @param sid    门店ID
	 * @param imgStr 证件图片base64
	 * @return
	 */

	@RequestMapping("/updateSpeCertiPicture")
	@ResponseBody
	public Msg updateSpeCertiPicture(Integer sid, String imgStr) {
		// 创建一个对象
		SpecialQualification iQ = new SpecialQualification();
		String path = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path);
		iQ.setId(sid);
		iQ.setCertificatePicture(path);
		//执行sql
		int val = specialQualificationService.updateByPrimaryKeySelective(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 重新上传个人身份资质的证件图片
	 * 
	 * @param sid    门店ID
	 * @param imgStr 证件图片base64
	 * @return
	 */
	@RequestMapping("/updatePerCertiPicture")
	@ResponseBody
	public Msg updatePerCertiPicture(Integer sid, String imgStr) {
		// 创建一个对象
		PersonalQualification PQ = new PersonalQualification();
		// 设置门店ID
		PQ.setSid(sid);
		String path1 = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path1);
		PQ.setIdcardPicone(path1);
		String path2 = CommonUtil.pathUrl();
		CommonUtil.GenerateImage(imgStr, "C:/upload" + path2);
		PQ.setIdcardPictwo(path2);
		//执行sql
		int val = personalQualificationService.updateByPrimaryKeySelective(PQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 删除行业资质的证件图片
	 * 
	 * @param sid                商家ID
	 * @param certificatePicture 证件图片
	 * @return
	 */

	@RequestMapping("/deleteIndusCertificatePicture")
	@ResponseBody
	public Msg deleteCertificatePicture(Integer sid, String certificatePicture) {
		// 创建一个对象
		IndustryQualification iQ = new IndustryQualification();
		// 设置商家ID
		iQ.setSid(sid);
		// 设置证件图片
		iQ.setCertificatePicture(certificatePicture);
		//执行sql
		int val = industryQualificationService.deleteCertificatePicture(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 删除主体资质的证件图片
	 * 
	 * @param sid                商家ID
	 * @param certificatePicture 证件图片
	 * @return
	 */
	@RequestMapping("/deleteBoCertificatePicture")
	@ResponseBody
	public Msg deleteBoCertificatePicture(Integer sid, String certificatePicture) {
		// 创建一个对象
		BodyQualifications iQ = new BodyQualifications();
		iQ.setSid(sid);
		iQ.setCertificatePicture(certificatePicture);
		//执行sql
		int val = bodyQualificationsService.deleteCertificatePic(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}
	}

	/**
	 * 删除特殊资质的证件图片
	 * 
	 * @param sid                 商家ID
	 * @param certificatePicture 证件图片
	 * @return
	 */

	@RequestMapping("/deleteSpeCertiPicture")
	@ResponseBody
	public Msg deleteSpeCertiPicture(Integer sid, String certificatePicture) {
		// 创建一个对象
		SpecialQualification iQ = new SpecialQualification();
		iQ.setSid(sid);
		iQ.setCertificatePicture(certificatePicture);
		//执行sql
		int val = specialQualificationService.deleteCertificatePicture(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 删除个人身份资质的证件图片
	 * 
	 * @param sid            商家ID
	 * @param idcardPicone 身份证证件正面照
	 * @param idcardPictwo 身份证证件反面照
	 * @return
	 */
	@RequestMapping("/deletePeCertiPicture")
	@ResponseBody
	public Msg deletePeCertiPicture(Integer sid, String idcardPicone,String idcardPictwo) {
		//创建一个对象
		PersonalQualification iQ = new PersonalQualification();
		//设置商家ID
		iQ.setSid(sid);
		//设置身份证证件正面照
		iQ.setIdcardPicone(idcardPicone);
		//设置身份证证件反面照
		iQ.setIdcardPictwo(idcardPictwo);
		//执行sql
		int val = personalQualificationService.deleteCertificatePicture(iQ);
		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}
	
	/**
	 * 查询个人资质认证
	 * 
	 * @param sid 商家门店表ID
	 * @return
	 */
	@RequestMapping("/selectPersonalQualification")
	@ResponseBody
	public Msg selectPersonalQualification(Integer sid) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//执行sql
		PersonalQualification PQ = personalQualificationService.selectByPrimaryKey(sid);

		if (PQ == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("PQ", PQ);

	}

	/**
	 * 修改个人资质认证
	 * 
	 * @param sid             商家门店表ID
	 * @param certificateType 证件类型
	 * @param realname        真实姓名
	 * @param certificateNo   证件号码
	 * @return
	 */
	@RequestMapping("/updatePersonalQualification")
	@ResponseBody
	public Msg updatePersonalQualification(Integer sid, String certificateType, String realname, String certificateNo,
			Integer certificationStatus) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		// 创建一个对象
		PersonalQualification PQ = new PersonalQualification();
		PQ.setSid(sid);
		PQ.setCertificateType(certificateType);
		PQ.setRealname(realname);
		PQ.setCertificateNo(certificateNo);
		PQ.setCertificationStatus(certificationStatus);
		//执行sql
		int val = personalQualificationService.updateByPrimaryKeySelective(PQ);

		if (val == 1) {
			return Msg.success();
		} else {
			return Msg.fail().add("msg", "修改失败！");
		}

	}

	/**
	 * 查询个人身份认证认证状态
	 * 
	 * @param sid 商家门店表ID
	 * @return
	 */
	@RequestMapping("/selectQualifiStatus")
	@ResponseBody
	public Msg selectQualifiStatus(Integer sid) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//执行sql
		PersonalQualification PQ = personalQualificationService.selectPerStatus(sid);

		if (PQ == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("PQ", PQ);

	}

	/**
	 * 查询门店资质认证认证状态
	 * 
	 * @param sid 商家门店表ID
	 * @return
	 */
	@RequestMapping("/selectShopQualifiStatus")
	@ResponseBody
	public Msg selectShopQualifiStatus(Integer sid) {
		if (sid == null) {
			return Msg.fail().add("msg", "参数不为空！");
		}
		//执行sql
		SpecialQualification PQ = specialQualificationService.selectShopQualifiStatus(sid);

		if (PQ == null) {
			return Msg.fail().add("msg", "无信息！");
		}
		return Msg.success().add("PQ", PQ);

	}

}
