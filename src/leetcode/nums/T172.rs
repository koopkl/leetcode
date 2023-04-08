pub struct Solution {}

impl Solution {
    pub fn trailing_zeroes(mut n: i32) -> i32 {
        // let mut res = 0;
        // for i in (5..=n).step_by(5) {
        //    let mut x = i;
        //     while x % 5 == 0 {
        //         x /= 5;
        //         res += 1;
        //     }
        // }
        // res

        let mut res = 0;
        while n > 0 {
            let ans = n / 5;
            res += ans;
            n /= 5;
        }
        res
    }
}