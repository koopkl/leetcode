pub struct Solution {}
impl Solution {
    pub fn bulb_switch(n: i32) -> i32 {
        // let mut bulbs = vec![0; n as usize];
        // for i in 0..n {
        //     for j in (i..n).step_by((i+1) as usize) {
        //         bulbs[j as usize] = 1 - bulbs[j as usize];
        //     }
        // }
        // bulbs.iter().fold(0, |acc, x| acc + x)
        (n as f64).sqrt() as i32
    }
}