use std::cell::RefCell;
use std::rc::Rc;

pub struct Solution {

}

impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        let m = mat.len();
        let n = mat[0].len();
        if ((m * n) as i32) != (r * c) {
            return mat;
        }
        let mut res: Vec<Rc<RefCell<Vec<i32>>>> = vec![];
        for i in 0..r {
            res.push(Rc::new(RefCell::new(vec![])));
        }
        let mut k = 0;
        let mut p = 0;

        for i in 0..m {
            for j in 0..n {
                if p >= c {
                    p = 0;
                    k += 1;
                }
                res[k].borrow_mut().push(mat[i][j]);
                p = p + 1;
            }
        }
        res.iter().map(|a| a.borrow().clone())
            .filter(|vec| !vec.is_empty())
            .collect::<Vec<Vec<i32>>>()
    }
}