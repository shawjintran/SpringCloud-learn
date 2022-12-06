package com.shaw.springcloud;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// @Order(-1)
//代表过滤器顺序,值越小,顺序越前
//也可以直接通过 Ordered接口实现
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

	@Override
	/**
	 *处理当前请求，有必要的话通过{@link GatewayFilterChain}将请求交给下一个过滤器处理*
	 * @param exchange 请求上下文，里面可以获取Request、Response等信息
	 * @param chain 用来把请求委托给下一个过滤器
	 *return {@code Mono<Void>}返回标示当前过滤器业务结束
	 **/
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		MultiValueMap<String, String> params = exchange.
				getRequest().//得到请求
				getQueryParams();//得到请求键值对
		String yes = params.getFirst("yes");
		if ("yes".equals(yes))
		{//放行
			return chain.filter(exchange);
		}
		//不放行,设置状态码后返回
		exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
		return exchange.getResponse().setComplete();
	}

	@Override
	public int getOrder() {
		return -1;
	//	过滤器顺序为-1
	}
}
