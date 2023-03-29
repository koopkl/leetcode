pub struct Solution {

}

impl Solution {
    pub fn repeated_string_match(a: String, b: String) -> i32{
        let mut flag = -1;
        let first = b.chars().next().unwrap();
        let mut count = 0;
        a.chars().for_each(|x| {
            if x == first && flag == -1{
                // println!("{x}, {first} {count}");
                if (b.len() + count) < a.len() {
                    if (&a[count..a.len()]).to_string().starts_with(b.clone().as_str()) {
                        flag = count as i32;
                    }
                } else {
                    let mut kk = a.repeat(2);
                    if (b.len() + count) <= kk.len() {
                        if (&kk[count..kk.len()]).to_string().starts_with(b.clone().as_str()) {
                            flag = count as i32;
                        }
                    } else {
                        if b.starts_with(&kk[count..kk.len()]) {
                            flag = count as i32;
                        }
                    }
                }

            }
            count += 1;
        });
        // println!("{flag}");
        if flag == -1 {
            return -1;
        }
        if (b.len() + flag as usize) < a.len() {
            return 1;
        }
        let mut j = 0;
        let a_chars = a.chars().collect::<Vec<char>>();
        let b_chars = b.chars().collect::<Vec<char>>();
        let mut res = 1;
        if flag == 0 {
            res = 0;
        }
        // println!("{flag}");
        // println!("{res}");
        while j < b_chars.len() {
            if ((flag as usize + j) %  a_chars.len()) == 0 {
                res += 1;
            }
            let x = a_chars[(flag as usize + j) % a_chars.len()];
            let y = b_chars[j];
            // println!("{x}, {y}");
            if x != y {
                return -1;
            }
            j += 1;
        }
        res
    }
}