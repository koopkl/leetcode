
// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>
}

impl ListNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        ListNode {
            next: None,
            val
        }
    }
}

pub struct Solution {

}

impl Solution {
    pub fn reverse_between(mut head: Option<Box<ListNode>>, left: i32, right: i32) -> Option<Box<ListNode>> {
        if left == right {
            return head;
        }
        let mut count = 0;
        let mut dump = Box::new(ListNode { val: -1, next: head });
        let mut pointer = dump.as_mut();
        while count < left-1 {
            pointer = pointer.next.as_mut().unwrap();
            count += 1;
        }
        // 此时pointer是被转转的第一个，接下来反转
        let mut prev = None;
        let mut cur = pointer.next.clone();

        // let mut cur = Some(Box::new(pointer.clone()));
        // println!("{:?}", cur);
        while let Some(mut node) = cur.clone() {
            if count < right {
                cur = node.next.take();
                node.next = prev;
                prev = Some(node);
                count += 1;
            } else {
                break
            }
        }
        pointer.next = prev;
        while pointer.next != None {
            pointer = pointer.next.as_mut().unwrap();
        }
        pointer.next = cur;
        dump.next
    }
}