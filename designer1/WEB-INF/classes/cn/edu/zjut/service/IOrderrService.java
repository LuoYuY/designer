package cn.edu.zjut.service;

import cn.edu.zjut.po.Designer;
import cn.edu.zjut.po.Employer;
import cn.edu.zjut.po.Orderr;

public interface IOrderrService {

	boolean changeOrderrSt(String orderrId, String state);

	Orderr getOrderrByID(String orderrId);

	boolean SubmitOrderr(Orderr orderr, Designer designer, Employer employer);

}
