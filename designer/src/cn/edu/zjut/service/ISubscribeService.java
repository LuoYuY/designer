package cn.edu.zjut.service;

import cn.edu.zjut.po.Subscribe;

public interface ISubscribeService {	
	public boolean subscribe(Subscribe sub,String employerId,String designerId);
	public void putSubscribe(Subscribe subscribe);
	public void accept(String subscribeID);
	public void reject(String subscribeID);
}
