// 작성자 : 김상규, 최연호

package repository;

import entity.Book;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookHashmapRepository extends HashmapRepository<Integer, Book> {
    public BookHashmapRepository(){
        init();
    }
    public List<Book> findByName(String name) {
        List<Book> all = findAll();
        return all.stream()
                .filter(x -> x.getName().contains(name))
                .toList();
    }
    public List<Book> getByName(String name){
        List<Book> all = findAll();
        return all.stream()
                .filter(x -> x.getName().equals(name)).toList();
    }


    public void init(){
        for(int i=0;i<10;i++){
            Book book=new Book(name.get(i),writer.get(i),publisher.get(i),date.get(i), i);
            hashMap.put(i,book);
        }
    }

    List<String> name= Arrays.asList("(수상한 이웃집) 시노다", "쉼터에 살았다", "쉼터에 살았다", "안녕 본본",
            "안녕 본본","나로 만든 집","서울 아이","열다섯, 그럴 나이","열다섯, 그럴 나이",
            "특별한 날 특별한 동화","편의점을 털어라!","편의점을 털어라!");
    List<String> writer=Arrays.asList("도미야스 요코 글;오바 켄야 그림;송지현 옮김","하람 지음","하람 지음",
            "정유진 지음","박영란 지음","박영란 지음","나윤아;범유진;우다영;이선주;탁경은 지음",
            "최도영 글;김민우 그림","정경원 글;박우희 그림","고은지 글;왕지성 그림");
    List<String> publisher=Arrays.asList("다산어린이","문학동네","문학동네","노란상상","우리학교","우리학교"
            ,"우리학교","별숲","북멘토(도서출판)","북멘토(도서출판)");
    List<String> date=Arrays.asList("","","","","","","","","","");


}
