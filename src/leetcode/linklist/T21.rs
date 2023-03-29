
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}

pub struct Solution {

}
impl Solution {
    pub fn merge_two_lists(mut list1: Option<Box<ListNode>>, mut list2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if list1.is_none() {
            return list2;
        }
        if list2.is_none() {
            return list1;
        }
        let mut begin_node = Box::new(ListNode::new(-1));
        let mut point1 = list1.as_ref();
        let mut point2 = list2.as_ref();
        let mut temp = begin_node.as_mut();
        while point1.is_some() && point2.is_some() {
            if point1.unwrap().val > point2.unwrap().val {
                temp.next = list2;
                temp = temp.next.as_mut().unwrap();
                list2 = temp.next.take();
            } else {
                temp.next = list1;
                temp = temp.next.as_mut().unwrap();
                list1 = temp.next.take();
            }
            point1 = list1.as_ref();
            point2 = list2.as_ref();
        }
        if point1.is_none() {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        begin_node.next
    }
}