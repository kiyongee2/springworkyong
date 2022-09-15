/**
 * 
 */
console.log("Reply Module...");
let replyService=(function(){
	//return {name:"AAAA"};
	//댓글 등록
	function add(reply, callback, error){
		console.log("reply........");
		
		$.ajax({
			type: "post",
			url: "/replies/new",
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result){
				if(callback){
					callback(result);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	// 댓글 목록
	function getList(param, callback, error){
		let bno = param.bno;
		let page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json", 
			function(data){
				if(callback){
					callback(data);
				}
			}).fail(function(xhr, status, err){
				if(error){
					error();
				}
			});
	}//getList 끝
	
	return {
		add : add,
		getList : getList
	};
})();