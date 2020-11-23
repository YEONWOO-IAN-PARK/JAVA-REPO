package kr.co.hta.app;

import java.util.Scanner;

import kr.co.hta.dao.BookDao;
import kr.co.hta.dao.OrderDao;
import kr.co.hta.dao.OrderItemDao;
import kr.co.hta.dao.PointHistoryDao;
import kr.co.hta.dao.UserDao;

public class JdbcStoreApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDao.getInstance();
		OrderDao.getInstance();
		OrderItemDao.getInstance();
		PointHistoryDao.getInstance();
		UserDao.getInstance();

		while(true) {
			System.out.println("###################[통합관리 프로그램]###################");
			System.out.println("========================================================");
			System.out.println("1.도서  2.주문  3.회원  4.포인트  0.종료");
			System.out.println("========================================================");
			System.out.println();

			System.out.println("메뉴선택 > ");
			int mainMenu = sc.nextInt();

			if(mainMenu == 1) {
				System.out.println("[도서관리]");
				System.out.println("======================================");
				System.out.println("1.전체조회   2.조회    3.추가   4.변경");
				System.out.println("======================================");

				System.out.println("메뉴선택 > ");
				int bookMenu = sc.nextInt();
				if (bookMenu == 1) {
					// 모든 책을 조회하는 기능
				}
				else if(bookMenu == 2) {
					// 책번호를 입력받아 특정책을 조회하는 기능
				}
				else if(bookMenu == 3) {
					// 새로운 책을 추가하는 기능
				}
				else if(bookMenu == 4) {
					// 책의 내용을 변경하는 기능
				}
			}
			else if(mainMenu == 2) {
				System.out.println("[주문관리]");
				System.out.println("====================================================");
				System.out.println("1.신규주문            2.주문조회          3.주문변경");
				System.out.println("====================================================");

				System.out.println("메뉴선택 > ");
				int orderMenu = sc.nextInt();

				if(orderMenu == 1) {
					// 새로운 주문을 추가하는 기능
					// OrderDao기능에서 주문번호를 자동으로 할당받는 메소드를 사용해
					// OrderItemDao의 변수들을 입력받아 작성한다.
				}
				else if(orderMenu == 2) {
					// 주문정보(주문번호,아이디,주문상태,가입일자)를 조회하는 기능(OrderDao)
					System.out.println("==================================");
					System.out.println("1.주문상태조회      2.주문상품조회");
					System.out.println("==================================");
					System.out.println("메뉴선택 > ");
					int orderInfo = sc.nextInt();
					if(orderInfo == 1) {
						// 1. userId를 입력받아 주문정보를 조회하는 기능(OrderDao.getOrderByUserId)
						// 2. orderNo를 입력받아 주문정보를 조회하는 기능(OrderDao.getOrderByNo)
					}
					else if(orderInfo == 2){
						// 3.주문한 상품에 관련된 정보를 조회하는 기능(OrderItemDao.getOrderItemsByOrderNo)
					}
				}
				else if(orderMenu == 3) {
					// 주문상태정보(orderNo, status)를 변경한다. (OrderDao.updateOrder)
				}
			}
			else if(mainMenu == 3) {
				System.out.println("[회원관리]");
				System.out.println("==============================================");
				System.out.println("1.회원조회      2.신규가입      3.회원정보변경");
				System.out.println("==============================================");

				System.out.println("메뉴선택 > ");
				int userMenu = sc.nextInt();
				
				if(userMenu == 1) {
					// 아이디로 회원을 검색하는 기능(UserDao.getUserByID)
				}
				else if(userMenu == 2) {
					// 새로운 회원정보를 추가하는 기능(UserDao.insertNewUser)
				}
				else if(userMenu == 3) {
					// 새로운 회원정보를 입력받아 회원정보를 변경하는 기능(UserDao.updateUser)
				}
			}
			else if(mainMenu == 4) {
				System.out.println("[포인트관리]");
				System.out.println("=========================================");
				System.out.println("1.포인트내역조회     	2.포인트내역 추가");
				System.out.println("=========================================");
						// *************************PointHistory가 어떤 클래스인지 알아보는게 제일 먼저*****************
				System.out.println("메뉴선택 > ");
				int pointMenu = sc.nextInt();
				
				if(pointMenu == 1) {
					// PointHistory를 조회한다. (PointHistory.getPointHistoriesByUserId)
				}
				else if(pointMenu == 2) {
					// 새로운 PointHistory를 추가한다. (PointHistory.insertPointHisotry)
				}
				
			}
			else if(mainMenu == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
		}
	}
}
