pub struct Solution {

}

impl Solution {
    pub fn image_smoother(img: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let m = img.len() as i32;
        let n = img[0].len() as i32;
        let mut res:Vec<Vec<i32>> = vec![];
        for i in 0..m {
            let mut temp_res = vec![];
            for j in 0..n {
                let mut sum  = 0;
                let mut count = 0;
                for l in i-1..i+2 {
                    for k in j - 1 .. j + 2{
                        let deal_value = Self::deal_value(Self::get_value(l,k, &img));
                        sum += deal_value.0;
                        count += deal_value.1;
                    }
                }
                temp_res.push(sum / count);
            }
            res.push(temp_res);
        }

        res
    }

    pub fn get_value(i: i32, j: i32, img: &Vec<Vec<i32>>) -> Option<i32>{
        let val = None;
        if i < 0 || j < 0 {
            return None;
        }
        if let Some(t1) = img.get(i as usize) {
            if let Some(t2) = t1.get(j as usize) {
                return Some(t2.clone());
            }
        }
        val
    }

    pub fn deal_value(val: Option<i32>) -> (i32, i32) {
        match val {
            Some(x) => (x, 1),
            None => (0, 0)
        }
    }


}