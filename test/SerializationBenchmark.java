import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import util.SaverLoaderUtil;





public class SerializationBenchmark {
	public static void main(String[] args) {
		for(int i = 1; i <= 10; ++i){
			saveNTimes(i);
		}
		for(int i = 10; i <= 1000; i += 10){
			saveNTimes(i);
		}
		
	}

	private static void saveNTimes(int times) {
		String fileName = "bench";
		try {
			SaverLoaderUtil.saveObjectNTimesToFile(getList(), fileName, times);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(fileName);
		long len = file.length();
		try {
			SaverLoaderUtil.saveGZipObjectNTimesToFile(getList(), fileName, times);
		} catch (IOException e) {
			e.printStackTrace();
		}
		file = new File(fileName);
		System.out.println(times + " : " + len + " : " + file.length());
	}
	
	private static List<String> getList(){
		List<String> result = new ArrayList<String>();
		result.add("sklsjklsdfjlsdkf");
		result.add("sklsjklsdqwqwqkf");
		result.add("swqewrererttryff");
		result.add("s;l;lkl;lk;k;k;f");
		result.add("skl23423423423kf");
		result.add("skl234234dklfdkf");
		result.add("skwerqwerfjlsdkf");
		result.add("sklsjklsweelsdkf");
		result.add("sklsjwer345tyukf");
		result.add("234ertfgyhjkldkf");
		result.add(",kjuytredfjlsdkf");
		result.add("ssdfghukiuytredf");
		result.add("dfghjui76fjlsdk9f");
		result.add("sksdfhju566trd9fg");
		result.add("skldfghtrdfls9dkf");
		result.add("sklsdfg1645e9rgfkf");
		result.add("szcxczxczxs9dfh6f");
		result.add("scbvcbc1vb9cvbvdkf");
		result.add("sbvnbvn1b9vnbvndkf");
		result.add("sn,nm,n19m,nmlsdkf");
		result.add("sklshty91trytytryf");
		result.add("sklsjk9l1sdfjlsdkf");
		result.add("sklsj9klsdqwqwqkf");
		result.add("swqe9wrerertt1ryff");
		result.add("s;l9;lkl;lk;k;k;f");
		result.add("sk9l234234223423kf");
		result.add("s9kl2334234dklfdkf");
		result.add("9skwe4rqwerfjlsdkf");
		result.add("skls5jwer345tyuk9f");
		result.add("234ertfgyhjkld8k9f");
		result.add(",kjuytredfjls8d9kf");
		result.add("ssdfghuk6iuy8t9redf");
		result.add("dfghjui767f8j9lsdkf");
		result.add("sksdfhju56869trdfg");
		result.add("skldfghtr879dflsdkf");
		result.add("sklsdfg78645ergfkf");
		result.add("szcxczx8cz9xsdfh6f");
		result.add("scbvcb88cvbcvbvdkf");
		result.add("sbvnb8vnb9vnbvndkf");
		result.add("sn,n8m,nm,nmlsdkf");
		result.add("skl8shtytrytytryf");
		return result; 
	}
}

