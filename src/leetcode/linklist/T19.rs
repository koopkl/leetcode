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
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut dump = Box::new(ListNode::new(-1));
        dump.next = head.clone();
        let mut i = 0;
        let mut j = 0;
        let mut left = dump.as_mut();
        let mut right = head.clone().unwrap();
        while right.next.is_some() {
            if j - i >= (n - 1) {
                i += 1;
                left = left.next.as_mut().unwrap();
            }
            j += 1;
            right = right.next.unwrap();
            println!("{:?}, {:?}", left, right);
        }
        left.next = left.next.as_ref().unwrap().next.clone();
        dump.next
    }
}